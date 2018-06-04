package com.smarthome.flat.svc.db;


import com.smarthome.flat.svc.model.Certificates;
import com.smarthome.flat.svc.model.TppsListReply;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

/** database tools for working with the tpp store database */
public class DBSupport {

  /** shared instance for working with DB */
  private JdbcTemplate jdbcTemplate;

  /**
   * constructor
   *
   * @param jdbcTemplate
   */
  public DBSupport(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * method for blocking/unblocking a TPP in the DB
   *
   * @param licenceId LICENCE_ID of the TPP
   * @param unblock flag if the record should be blocked
   * @return true if success otherwise false, null if the provided tpp not exists
   */
  public Boolean block(String licenceId, String countryCode, String reason, boolean unblock) {
    countryCode = countryCode.trim().toUpperCase();
    Boolean blocked =
        jdbcTemplate.query(
            "SELECT BLOCKED FROM LICENCES where LICENCE_ID= ? and COUNTRY = ?",
            new BooleanExtractorWithNull(),
            licenceId,
            countryCode);

    if (blocked == null) {
      return null; // no licence found means there is also no certificate in the DB
    } else {
      if (blocked != unblock) { // its already in the desired state
        return false;
      } else {
        jdbcTemplate.update(
            "UPDATE LICENCES SET BLOCKED = ?, REASON = ?, LAST_CHANGE = now()  WHERE LICENCE_ID= ? and COUNTRY = ?",
            !unblock,
            reason,
            licenceId,
            countryCode);
        return true;
      }
    }
  }

  /**
   * method for searching for TPPs with the specified parameters
   *
   * @param tppName name of TPP
   * @param countryCode country of the TPP
   * @param isBlocked block flag
   * @param pageSize paging page size
   * @param cursor paging index of first item
   * @param roles roles of the TPP
   * @param licenceId registration id of the TPP
   * @param registratorCountry name of the portal TPP is registered to
   * @return {@link TppsListReply} instance
   */
  public TppsListReply getCerts(
      String tppName,
      String countryCode,
      Boolean isBlocked,
      String pageSize,
      String cursor,
      String roles,
      String licenceId,
      String registrator,
      String registratorCountry) {
    List<Integer> typesList = new ArrayList<Integer>();
    List<Object> values = new ArrayList<Object>();

    addParam(tppName, Types.VARCHAR, typesList, values);
    addParam(countryCode, Types.VARCHAR, typesList, values);
    addParam(isBlocked, Types.BOOLEAN, typesList, values);
    addParam(roles, Types.VARCHAR, typesList, values);
    addParam(licenceId, Types.VARCHAR, typesList, values);
    addParam(registrator, Types.VARCHAR, typesList, values);
    addParam(registratorCountry, Types.VARCHAR, typesList, values);

    int[] types = typesList.isEmpty() ? null : new int[typesList.size()];
    int index = 0;
    for (int i : typesList) {
      types[index] = i;
      index++;
    }

    Integer count;
    if (values.isEmpty()) {
      count =
          jdbcTemplate.query(
              "SELECT count(distinct c.ID) FROM CERTIFICATES c, CERTIFICATES_LICENCES cl, LICENCES l WHERE c.ID = cl.FK_CERTIFICATES_ID AND cl.FK_LICENCES_ID = l.ID "
                  + getCertsFilteringSelect(
                      tppName,
                      countryCode,
                      isBlocked,
                      roles,
                      licenceId,
                      registrator,
                      registratorCountry),
              new IntegerExtractor());
    } else {
      count =
          jdbcTemplate.query(
              "SELECT count(distinct c.ID) FROM CERTIFICATES c, CERTIFICATES_LICENCES cl, LICENCES l WHERE c.ID = cl.FK_CERTIFICATES_ID AND cl.FK_LICENCES_ID = l.ID "
                  + getCertsFilteringSelect(
                      tppName,
                      countryCode,
                      isBlocked,
                      roles,
                      licenceId,
                      registrator,
                      registratorCountry),
              values.toArray(),
              types,
              new IntegerExtractor());
    }

    typesList = new ArrayList<Integer>();
    values = new ArrayList<Object>();

    addParam(tppName, Types.VARCHAR, typesList, values);
    addParam(countryCode, Types.VARCHAR, typesList, values);
    addParam(isBlocked, Types.BOOLEAN, typesList, values);
    addParam(roles, Types.VARCHAR, typesList, values);
    addParam(licenceId, Types.VARCHAR, typesList, values);
    addParam(registrator, Types.VARCHAR, typesList, values);
    addParam(registratorCountry, Types.VARCHAR, typesList, values);
    addParam(
        cursor != null && cursor.length() > 0 ? Integer.valueOf(cursor) : null,
        Types.NUMERIC,
        typesList,
        values);
    addParam(
        pageSize != null && pageSize.length() > 0 ? Integer.valueOf(pageSize) : null,
        Types.NUMERIC,
        typesList,
        values);

    types = typesList.isEmpty() ? null : new int[typesList.size()];
    index = 0;
    for (int i : typesList) {
      types[index] = i;
      index++;
    }

    List<Certificates> certs;

    String query =
        "SELECT c.*, l.* FROM CERTIFICATES c, CERTIFICATES_LICENCES cl, LICENCES l WHERE c.ID = cl.FK_CERTIFICATES_ID AND cl.FK_LICENCES_ID = l.ID "
            + getCertsFilteringSelect(
                tppName, countryCode, isBlocked, roles, licenceId, registrator, registratorCountry)
            + " ORDER BY c.TPP_NAME, c.ORG_ID "
            + getCertsPagingSelect(pageSize, cursor);

    if (values.isEmpty()) {
      certs = jdbcTemplate.query(query, new CertificatesRowMapper());
    } else {
      certs = jdbcTemplate.query(query, values.toArray(), types, new CertificatesRowMapper());
    }

    List<Certificates> compactList = compactCerts(certs);

    return new TppsListReply().totalSize(count).certificates(compactList);
  }

  /**
   * method for adding the specified sql parameter value to the typesList and values {@link List}
   *
   * @param value
   * @param type
   * @param typesList
   * @param values
   */
  protected void addParam(Object value, int type, List<Integer> typesList, List<Object> values) {
    if (value != null) {
      typesList.add(type);
      if (value instanceof String) {
        values.add("%" + value + "%");
      } else {
        values.add(value);
      }
    }
  }

  /**
   * method for compacting the list of {@link Certificates}
   *
   * @param certs
   * @return
   */
  private List<Certificates> compactCerts(List<Certificates> certs) {
    List<Certificates> compactList = new ArrayList<Certificates>();

    Certificates lastCert = null;
    for (Certificates cert : certs) {
      if (lastCert != null
          && lastCert.getFingerprint().equals(cert.getFingerprint())
          && lastCert.getOrgId().equals(cert.getOrgId())) {
        lastCert.addCountriesItem(cert.getCountries().get(0));
      } else {
        lastCert = cert;
        compactList.add(cert);
      }
    }
    return compactList;
  }

  /**
   * method for constructing the filtering for selecting the tpps
   *
   * @param tppName
   * @param countryCode
   * @param isBlocked
   * @param roles
   * @param licenceId
   * @param registratorCountry
   * @return
   */
  protected String getCertsFilteringSelect(
      String tppName,
      String countryCode,
      Boolean isBlocked,
      String roles,
      String licenceId,
      String registrator,
      String registratorCountry) {
    StringBuilder sb = new StringBuilder();

    addSelectWhereField(sb, "c.TPP_NAME", " like ", tppName, true);
    addSelectWhereField(sb, "l.COUNTRY", " like ", countryCode, true);
    addSelectWhereField(sb, "l.BLOCKED", "=", isBlocked, true);
    addSelectWhereField(sb, "c.ROLES", " like ", roles, true);
    addSelectWhereField(sb, "l.LICENCE_ID", " like ", licenceId, true);
    addSelectWhereField(sb, "c.REGISTRATOR", " like ", registrator, true);
    addSelectWhereField(sb, "c.REGISTRATOR_COUNTRY", " like ", registratorCountry, true);

    return sb.toString();
  }

  /**
   * method for constructing the paging for selecting the tpps
   *
   * @param pageSize
   * @param cursor
   * @return
   */
  protected String getCertsPagingSelect(String pageSize, String cursor) {
    StringBuilder sb = new StringBuilder();

    if (cursor != null && cursor.length() > 0) {
      addSelectWhereField(sb, "OFFSET", " ", Integer.valueOf(cursor), false);
    }
    if (pageSize != null && pageSize.length() > 0) {
      addSelectWhereField(sb, "LIMIT", " ", Integer.valueOf(pageSize), false);
    }

    return sb.toString();
  }

  /**
   * method for appending a where part to the {@link StringBuffer}
   *
   * @param sb
   * @param columnName
   * @param operation
   * @param columnValue
   * @param useAnd
   */
  protected void addSelectWhereField(
      StringBuilder sb, String columnName, String operation, Object columnValue, boolean useAnd) {
    if (columnValue != null) {
      if (useAnd) {
        sb.append(" and ");
      } else {
        sb.append(" ");
      }
      sb.append(columnName);
      sb.append(operation);
      sb.append("?");
    }
  }

  /**
   * method for verification of the tpp
   *
   * @param orgId org_id (or tpp_id) from the request
   * @param registrationId registration_id (or license_id) from the certificate
   * @param registrator registrator from the certificate
   * @param countryCode country code belongs to business api specified in API-C
   * @param tppName tpp_name from the certificate
   * @param fingerPrint unique fingerprint from the certificate
   * @param registratorCountry two letters abbreviaton of registrator_country from the certificate
   * @param validFrom starting datetime of validity of certificate (format can be different based on
   *     country)
   * @param validTo ending datetime of validity of certificate (format can be different based on
   *     country)
   * @param rolesString comma separated list of roles from the certificate
   * @return instance of {@link TppVerifyResult}
   */
/*  @Transactional
  public TppVerifyResult verifyTpp(
      String orgId,
      String registrationId,
      String registrator,
      String countryCode,
      String tppName,
      String fingerPrint,
      String registratorCountry,
      Date validFrom,
      Date validTo,
      String rolesString) {

    Boolean blocked;
    Integer count;
    Long certificatesId;
    long licencesId;

    SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy HH:mm:ss");

    certificatesId =
        jdbcTemplate.query(
            "SELECT ID FROM CERTIFICATES c WHERE FINGERPRINT= ? AND ORG_ID= ?",
            new LongExtractor(),
            fingerPrint,
            orgId);

    if (certificatesId == null) {
      jdbcTemplate.update(
          "INSERT INTO CERTIFICATES "
              + "(FINGERPRINT, ORG_ID, TPP_NAME, REGISTRATOR, REGISTRATOR_COUNTRY, "
              + "ROLES, VALID_FROM,VALID_TO, CREATED, USED_LAST) "
              + "VALUES (?, ?, ?, ?, ?, ?, to_timestamp(?, ?), to_timestamp(?, ?), now(), now()) ",
          fingerPrint,
          orgId,
          tppName,
          registrator,
          registratorCountry,
          rolesString,
          format.format(validFrom),
          getDatetimePattern(countryCode),
          format.format(validTo),
          getDatetimePattern(countryCode));

      certificatesId =
          jdbcTemplate.query(
              "SELECT ID FROM CERTIFICATES WHERE FINGERPRINT= ? AND ORG_ID= ?",
              new LongExtractor(),
              fingerPrint,
              orgId);

      jdbcTemplate.update(
          "INSERT INTO LICENCES (COUNTRY, LICENCE_ID, LAST_CHANGE, BLOCKED) VALUES (?, ?, now(), FALSE) ",
          countryCode,
          registrationId);

      licencesId =
          jdbcTemplate.query(
              "SELECT ID FROM LICENCES WHERE COUNTRY= ? AND LICENCE_ID= ?",
              new LongExtractor(),
              countryCode,
              registrationId);

      jdbcTemplate.update(
          "INSERT INTO CERTIFICATES_LICENCES (FK_CERTIFICATES_ID, FK_LICENCES_ID) VALUES (?, ?)",
          certificatesId,
          licencesId);

      return TppVerifyResult.OK;
    } else {
      // update used_last column every time when we call the svc with a stored certificate
      jdbcTemplate.update(
          "UPDATE CERTIFICATES SET USED_LAST = now() WHERE FINGERPRINT= ? AND ORG_ID= ?",
          fingerPrint,
          orgId);

      blocked =
          jdbcTemplate.query(
              "SELECT l.BLOCKED FROM CERTIFICATES c, CERTIFICATES_LICENCES cl, LICENCES l WHERE c.ID = cl.FK_CERTIFICATES_ID AND cl.FK_LICENCES_ID = l.ID AND c.FINGERPRINT = ? AND c.ORG_ID = ? AND l.COUNTRY = ?",
              new BooleanExtractorWithNull(),
              fingerPrint,
              orgId,
              countryCode);

      // ne block for this country
      if (blocked == null) {
        jdbcTemplate.update(
            "INSERT INTO LICENCES (COUNTRY, LICENCE_ID, LAST_CHANGE, BLOCKED) VALUES (?, ?, now(), FALSE) ",
            countryCode,
            registrationId);

        licencesId =
            jdbcTemplate.query(
                "SELECT ID FROM LICENCES WHERE COUNTRY= ? AND LICENCE_ID= ?",
                new LongExtractor(),
                countryCode,
                registrationId);

        jdbcTemplate.update(
            "INSERT INTO CERTIFICATES_LICENCES (FK_CERTIFICATES_ID, FK_LICENCES_ID) VALUES (?, ?)",
            certificatesId,
            licencesId);

        return TppVerifyResult.OK;
      } else {
        if (!blocked) {
          return TppVerifyResult.OK;
        } else {
          return TppVerifyResult.BLOCKED_LICENCE;
        }
      }
    }
  }*/
}
