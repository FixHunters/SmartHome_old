package com.smarthome.flat.svc.db;

import com.smarthome.flat.svc.model.Certificates;
import com.smarthome.flat.svc.model.Countries;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.threeten.bp.DateTimeUtils;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;

public class CertificatesRowMapper implements RowMapper<Certificates> {

  @Override
  public Certificates mapRow(ResultSet rs, int rowNum) throws SQLException {
    Certificates res = new Certificates();
    res.orgId(rs.getString("ORG_ID"))
        .fingerprint(rs.getString("FINGERPRINT"))
        .tppName(rs.getString("TPP_NAME"))
        .registrator(rs.getString("REGISTRATOR"))
        .registratorCountry(rs.getString("REGISTRATOR_COUNTRY"))
        .roles(rs.getString("ROLES"))
        .validFrom(
            OffsetDateTime.ofInstant(
                DateTimeUtils.toInstant(rs.getTimestamp("VALID_FROM")), ZoneId.systemDefault()))
        .validTo(
            OffsetDateTime.ofInstant(
                DateTimeUtils.toInstant(rs.getTimestamp("VALID_TO")), ZoneId.systemDefault()))
        .created(
            OffsetDateTime.ofInstant(
                DateTimeUtils.toInstant(rs.getTimestamp("CREATED")), ZoneId.systemDefault()))
        .usedLast(
            OffsetDateTime.ofInstant(
                DateTimeUtils.toInstant(rs.getTimestamp("USED_LAST")), ZoneId.systemDefault()))
        .licenceId(rs.getString("LICENCE_ID"))
        .addCountriesItem(
            new Countries()
                .blocked(rs.getString("BLOCKED"))
                .reason(rs.getString("REASON"))
                .country(rs.getString("COUNTRY"))
                .lastChange(
                    OffsetDateTime.ofInstant(
                        DateTimeUtils.toInstant(rs.getTimestamp("LAST_CHANGE")),
                        ZoneId.systemDefault())));

    return res;
  }
}
