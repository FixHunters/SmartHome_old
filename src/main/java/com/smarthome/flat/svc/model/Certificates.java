package com.smarthome.flat.svc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;
import com.smarthome.flat.svc.config.CustomOffsetDateTimeSerializer;

/** Certificates */
@Validated
@javax.annotation.Generated(
  value = "io.swagger.codegen.languages.SpringCodegen",
  date = "2018-04-03T15:24:02.669+02:00"
)
public class Certificates {
  @JsonProperty("fingerprint")
  private String fingerprint = null;

  @JsonProperty("orgId")
  private String orgId = null;

  @JsonProperty("tppName")
  private String tppName = null;

  @JsonProperty("licenceId")
  private String licenceId = null;

  @JsonProperty("registrator")
  private String registrator = null;

  @JsonProperty("registratorCountry")
  private String registratorCountry = null;

  @JsonProperty("roles")
  private String roles = null;

  @JsonProperty("validFrom")
  @JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
  private OffsetDateTime validFrom = null;

  @JsonProperty("validTo")
  @JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
  private OffsetDateTime validTo = null;

  @JsonProperty("created")
  @JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
  private OffsetDateTime created = null;

  @JsonProperty("usedLast")
  @JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
  private OffsetDateTime usedLast = null;

  @JsonProperty("countries")
  @Valid
  private List<Countries> countries = null;

  public Certificates fingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
    return this;
  }

  /**
   * Get fingerprint
   *
   * @return fingerprint
   */
  @ApiModelProperty(value = "")
  public String getFingerprint() {
    return fingerprint;
  }

  public void setFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
  }

  public Certificates orgId(String orgId) {
    this.orgId = orgId;
    return this;
  }

  /**
   * Get orgId
   *
   * @return orgId
   */
  @ApiModelProperty(value = "")
  public String getOrgId() {
    return orgId;
  }

  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }

  public Certificates tppName(String tppName) {
    this.tppName = tppName;
    return this;
  }

  /**
   * Get tppName
   *
   * @return tppName
   */
  @ApiModelProperty(value = "")
  public String getTppName() {
    return tppName;
  }

  public void setTppName(String tppName) {
    this.tppName = tppName;
  }

  public Certificates licenceId(String licenceId) {
    this.licenceId = licenceId;
    return this;
  }

  /**
   * Get licenceId
   *
   * @return licenceId
   */
  @ApiModelProperty(value = "")
  public String getLicenceId() {
    return licenceId;
  }

  public void setLicenceId(String licenceId) {
    this.licenceId = licenceId;
  }

  public Certificates registrator(String registrator) {
    this.registrator = registrator;
    return this;
  }

  /**
   * Get registrator
   *
   * @return registrator
   */
  @ApiModelProperty(value = "")
  public String getRegistrator() {
    return registrator;
  }

  public void setRegistrator(String registrator) {
    this.registrator = registrator;
  }

  public Certificates registratorCountry(String registratorCountry) {
    this.registratorCountry = registratorCountry;
    return this;
  }

  /**
   * Get registratorCountry
   *
   * @return registratorCountry
   */
  @ApiModelProperty(value = "")
  public String getRegistratorCountry() {
    return registratorCountry;
  }

  public void setRegistratorCountry(String registratorCountry) {
    this.registratorCountry = registratorCountry;
  }

  public Certificates roles(String roles) {
    this.roles = roles;
    return this;
  }

  /**
   * Get roles
   *
   * @return roles
   */
  @ApiModelProperty(value = "")
  public String getRoles() {
    return roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }

  public Certificates validFrom(OffsetDateTime validFrom) {
    this.validFrom = validFrom;
    return this;
  }

  /**
   * Get validFrom
   *
   * @return validFrom
   */
  @ApiModelProperty(value = "")
  @Valid
  public OffsetDateTime getValidFrom() {
    return validFrom;
  }

  public void setValidFrom(OffsetDateTime validFrom) {
    this.validFrom = validFrom;
  }

  public Certificates validTo(OffsetDateTime validTo) {
    this.validTo = validTo;
    return this;
  }

  /**
   * Get validTo
   *
   * @return validTo
   */
  @ApiModelProperty(value = "")
  @Valid
  public OffsetDateTime getValidTo() {
    return validTo;
  }

  public void setValidTo(OffsetDateTime validTo) {
    this.validTo = validTo;
  }

  public Certificates created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Get created
   *
   * @return created
   */
  @ApiModelProperty(value = "")
  @Valid
  public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public Certificates usedLast(OffsetDateTime usedLast) {
    this.usedLast = usedLast;
    return this;
  }

  /**
   * Get usedLast
   *
   * @return usedLast
   */
  @ApiModelProperty(value = "")
  @Valid
  public OffsetDateTime getUsedLast() {
    return usedLast;
  }

  public void setUsedLast(OffsetDateTime usedLast) {
    this.usedLast = usedLast;
  }

  public Certificates countries(List<Countries> countries) {
    this.countries = countries;
    return this;
  }

  public Certificates addCountriesItem(Countries countriesItem) {
    if (this.countries == null) {
      this.countries = new ArrayList<Countries>();
    }
    this.countries.add(countriesItem);
    return this;
  }

  /**
   * Get countries
   *
   * @return countries
   */
  @ApiModelProperty(value = "")
  @Valid
  public List<Countries> getCountries() {
    return countries;
  }

  public void setCountries(List<Countries> countries) {
    this.countries = countries;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Certificates certificates = (Certificates) o;
    return Objects.equals(this.fingerprint, certificates.fingerprint)
        && Objects.equals(this.orgId, certificates.orgId)
        && Objects.equals(this.tppName, certificates.tppName)
        && Objects.equals(this.licenceId, certificates.licenceId)
        && Objects.equals(this.registrator, certificates.registrator)
        && Objects.equals(this.registratorCountry, certificates.registratorCountry)
        && Objects.equals(this.roles, certificates.roles)
        && Objects.equals(this.validFrom, certificates.validFrom)
        && Objects.equals(this.validTo, certificates.validTo)
        && Objects.equals(this.created, certificates.created)
        && Objects.equals(this.usedLast, certificates.usedLast)
        && Objects.equals(this.countries, certificates.countries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        fingerprint,
        orgId,
        tppName,
        licenceId,
        registrator,
        registratorCountry,
        roles,
        validFrom,
        validTo,
        created,
        usedLast,
        countries);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Certificates {\n");

    sb.append("    fingerprint: ").append(toIndentedString(fingerprint)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    tppName: ").append(toIndentedString(tppName)).append("\n");
    sb.append("    licenceId: ").append(toIndentedString(licenceId)).append("\n");
    sb.append("    registrator: ").append(toIndentedString(registrator)).append("\n");
    sb.append("    registratorCountry: ").append(toIndentedString(registratorCountry)).append("\n");
    sb.append("    roles: ").append(toIndentedString(roles)).append("\n");
    sb.append("    validFrom: ").append(toIndentedString(validFrom)).append("\n");
    sb.append("    validTo: ").append(toIndentedString(validTo)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    usedLast: ").append(toIndentedString(usedLast)).append("\n");
    sb.append("    countries: ").append(toIndentedString(countries)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
