package com.smarthome.flat.svc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.smarthome.flat.svc.config.CustomOffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

/** Countries */
@Validated
@javax.annotation.Generated(
  value = "io.swagger.codegen.languages.SpringCodegen",
  date = "2018-04-03T15:24:02.669+02:00"
)
public class Countries {
  @JsonProperty("country")
  private String country = null;

  @JsonProperty("blocked")
  private String blocked = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("lastChange")
  @JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
  private OffsetDateTime lastChange = null;

  public Countries country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   *
   * @return country
   */
  @ApiModelProperty(value = "")
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Countries blocked(String blocked) {
    this.blocked = blocked;
    return this;
  }

  /**
   * Get blocked
   *
   * @return blocked
   */
  @ApiModelProperty(value = "")
  public String getBlocked() {
    return blocked;
  }

  public void setBlocked(String blocked) {
    this.blocked = blocked;
  }

  public Countries reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Get reason
   *
   * @return reason
   */
  @ApiModelProperty(value = "")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public Countries lastChange(OffsetDateTime lastChange) {
    this.lastChange = lastChange;
    return this;
  }

  /**
   * Get lastChange
   *
   * @return lastChange
   */
  @ApiModelProperty(value = "")
  @Valid
  public OffsetDateTime getLastChange() {
    return lastChange;
  }

  public void setLastChange(OffsetDateTime lastChange) {
    this.lastChange = lastChange;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Countries countries = (Countries) o;
    return Objects.equals(this.country, countries.country)
        && Objects.equals(this.blocked, countries.blocked)
        && Objects.equals(this.reason, countries.reason)
        && Objects.equals(this.lastChange, countries.lastChange);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, blocked, reason, lastChange);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Countries {\n");

    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    blocked: ").append(toIndentedString(blocked)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    lastChange: ").append(toIndentedString(lastChange)).append("\n");
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
