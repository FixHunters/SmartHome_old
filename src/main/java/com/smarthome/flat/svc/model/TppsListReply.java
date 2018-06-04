package com.smarthome.flat.svc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.springframework.validation.annotation.Validated;

/** TppsListReply */
@Validated
@javax.annotation.Generated(
  value = "io.swagger.codegen.languages.SpringCodegen",
  date = "2018-04-03T15:24:02.669+02:00"
)
public class TppsListReply {
  @JsonProperty("totalSize")
  private Integer totalSize = null;

  @JsonProperty("certificates")
  @Valid
  private List<Certificates> certificates = null;

  public TppsListReply totalSize(Integer totalSize) {
    this.totalSize = totalSize;
    return this;
  }

  /**
   * Get totalSize
   *
   * @return totalSize
   */
  @ApiModelProperty(value = "")
  public Integer getTotalSize() {
    return totalSize;
  }

  public void setTotalSize(Integer totalSize) {
    this.totalSize = totalSize;
  }

  public TppsListReply certificates(List<Certificates> certificates) {
    this.certificates = certificates;
    return this;
  }

  public TppsListReply addCertificatesItem(Certificates certificatesItem) {
    if (this.certificates == null) {
      this.certificates = new ArrayList<Certificates>();
    }
    this.certificates.add(certificatesItem);
    return this;
  }

  /**
   * Get certificates
   *
   * @return certificates
   */
  @ApiModelProperty(value = "")
  @Valid
  public List<Certificates> getCertificates() {
    return certificates;
  }

  public void setCertificates(List<Certificates> certificates) {
    this.certificates = certificates;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TppsListReply tppsListReply = (TppsListReply) o;
    return Objects.equals(this.totalSize, tppsListReply.totalSize)
        && Objects.equals(this.certificates, tppsListReply.certificates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalSize, certificates);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TppsListReply {\n");

    sb.append("    totalSize: ").append(toIndentedString(totalSize)).append("\n");
    sb.append("    certificates: ").append(toIndentedString(certificates)).append("\n");
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
