package br.com.slc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSlcLiquidProdt extends AbstractModel {

  @NotBlank
  @Column(nullable = false)
  private String identdLinhaBilat;

  @NotNull
  @Column(nullable = false, length = 1)
  private char tpDebCred;

  @NotNull
  @Column(nullable = false)
  private Long ispbifcCredtd;

  @NotNull
  @Column(nullable = false)
  private Long ispbifDebtd;

  @NotNull
  @Column(nullable = false)
  private BigDecimal vlrLanc;

  @NotBlank
  @Column(nullable = false)
  private String cnpjNLiqdantDebtd;

  @NotBlank
  @Column(nullable = false)
  private String nomCliDebtd;

  @NotBlank
  @Column(nullable = false)
  private String cnpjNLiqdantCredtd;

  @NotBlank
  @Column(nullable = false)
  private String nomCliCredtd;

  @NotBlank
  @Column(nullable = false)
  private String tpTranscSlc;

  public GrupoSlcLiquidProdt() {
  }

  public String getIdentdLinhaBilat() {
    return identdLinhaBilat;
  }

  @JsonProperty("IdentdLinhaBilat")
  public void setIdentdLinhaBilat(String identdLinhaBilat) {
    this.identdLinhaBilat = identdLinhaBilat;
  }

  public char getTpDebCred() {
    return tpDebCred;
  }

  @JsonProperty("TpDeb_Cred")
  public void setTpDebCred(char tpDebCred) {
    this.tpDebCred = tpDebCred;
  }

  public Long getIspbifcCredtd() {
    return ispbifcCredtd;
  }

  @JsonProperty("ISPBIFCredtd")
  public void setIspbifcCredtd(Long ispbifcCredtd) {
    this.ispbifcCredtd = ispbifcCredtd;
  }

  public Long getIspbifDebtd() {
    return ispbifDebtd;
  }

  @JsonProperty("ISPBIFDebtd")
  public void setIspbifDebtd(Long ispbifDebtd) {
    this.ispbifDebtd = ispbifDebtd;
  }

  public BigDecimal getVlrLanc() {
    return vlrLanc;
  }

  @JsonProperty("VlrLanc")
  public void setVlrLanc(BigDecimal vlrLanc) {
    this.vlrLanc = vlrLanc;
  }

  public String getCnpjNLiqdantDebtd() {
    return cnpjNLiqdantDebtd;
  }

  @JsonProperty("CNPJNLiqdantDebtd")
  public void setCnpjNLiqdantDebtd(String cnpjNLiqdantDebtd) {
    this.cnpjNLiqdantDebtd = cnpjNLiqdantDebtd;
  }

  public String getNomCliDebtd() {
    return nomCliDebtd;
  }

  @JsonProperty("NomCliDebtd")
  public void setNomCliDebtd(String nomCliDebtd) {
    this.nomCliDebtd = nomCliDebtd;
  }

  public String getCnpjNLiqdantCredtd() {
    return cnpjNLiqdantCredtd;
  }

  @JsonProperty("CNPJNLiqdantCredtd")
  public void setCnpjNLiqdantCredtd(String cnpjNLiqdantCredtd) {
    this.cnpjNLiqdantCredtd = cnpjNLiqdantCredtd;
  }

  public String getNomCliCredtd() {
    return nomCliCredtd;
  }

  @JsonProperty("NomCliCredtd")
  public void setNomCliCredtd(String nomCliCredtd) {
    this.nomCliCredtd = nomCliCredtd;
  }

  public String getTpTranscSlc() {
    return tpTranscSlc;
  }

  @JsonProperty("TpTranscSLC")
  public void setTpTranscSlc(String tpTranscSlc) {
    this.tpTranscSlc = tpTranscSlc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GrupoSlcLiquidProdt)) return false;
    GrupoSlcLiquidProdt that = (GrupoSlcLiquidProdt) o;
    return tpDebCred == that.tpDebCred &&
        identdLinhaBilat.equals(that.identdLinhaBilat) &&
        ispbifcCredtd.equals(that.ispbifcCredtd) &&
        ispbifDebtd.equals(that.ispbifDebtd) &&
        vlrLanc.equals(that.vlrLanc) &&
        cnpjNLiqdantDebtd.equals(that.cnpjNLiqdantDebtd) &&
        nomCliDebtd.equals(that.nomCliDebtd) &&
        cnpjNLiqdantCredtd.equals(that.cnpjNLiqdantCredtd) &&
        nomCliCredtd.equals(that.nomCliCredtd) &&
        tpTranscSlc.equals(that.tpTranscSlc);
  }

  @Override
  public int hashCode() {
    return Objects
        .hash(identdLinhaBilat, tpDebCred, ispbifcCredtd, ispbifDebtd, vlrLanc, cnpjNLiqdantDebtd, nomCliDebtd,
            cnpjNLiqdantCredtd, nomCliCredtd, tpTranscSlc);
  }

  @Override
  public String toString() {
    return "{\"GrupoSlcLiquidProdt\":"
        + ", \"identdLinhaBilat\":\"" + identdLinhaBilat + "\""
        + ", \"tpDebCred\":\"" + tpDebCred + "\""
        + ", \"ispbifcCredtd\":\"" + ispbifcCredtd + "\""
        + ", \"ispbifDebtd\":\"" + ispbifDebtd + "\""
        + ", \"vlrLanc\":\"" + vlrLanc + "\""
        + ", \"cnpjNLiqdantDebtd\":\"" + cnpjNLiqdantDebtd + "\""
        + ", \"nomCliDebtd\":\"" + nomCliDebtd + "\""
        + ", \"cnpjNLiqdantCredtd\":\"" + cnpjNLiqdantCredtd + "\""
        + ", \"nomCliCredtd\":\"" + nomCliCredtd + "\""
        + ", \"tpTranscSlc\":\"" + tpTranscSlc + "\""
        + "}";
  }

}
