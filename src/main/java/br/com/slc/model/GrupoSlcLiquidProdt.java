package br.com.slc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSlcLiquidProdt extends AbstractModel {

  private String identdLinhaBilat;

  private char tpDebCred;

  private Long ispbifcCredtd;

  private Long ispbifDebtd;

  private BigDecimal vlrLanc;

  @Size(max = 14)
  private Long cnpjNLiqdantDebtd;

  private String nomCliDebtd;

  @Size(max = 14)
  private Long cnpjNCNPJNLiqdantCredtd;

  private String nomCliCredtd;

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

  public Long getCnpjNLiqdantDebtd() {
    return cnpjNLiqdantDebtd;
  }

  @JsonProperty("CNPJNLiqdantDebtd")
  public void setCnpjNLiqdantDebtd(Long cnpjNLiqdantDebtd) {
    this.cnpjNLiqdantDebtd = cnpjNLiqdantDebtd;
  }

  public String getNomCliDebtd() {
    return nomCliDebtd;
  }

  @JsonProperty("NomCliDebtd")
  public void setNomCliDebtd(String nomCliDebtd) {
    this.nomCliDebtd = nomCliDebtd;
  }

  public Long getCnpjNCNPJNLiqdantCredtd() {
    return cnpjNCNPJNLiqdantCredtd;
  }

  @JsonProperty("CNPJNLiqdantCredtd")
  public void setCnpjNCNPJNLiqdantCredtd(Long cnpjNCNPJNLiqdantCredtd) {
    this.cnpjNCNPJNLiqdantCredtd = cnpjNCNPJNLiqdantCredtd;
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
  public String toString() {
    return "{\"GrupoSlcLiquidProdt\":"
        + ", \"identdLinhaBilat\":\"" + identdLinhaBilat + "\""
        + ", \"tpDebCred\":\"" + tpDebCred + "\""
        + ", \"ispbifcCredtd\":\"" + ispbifcCredtd + "\""
        + ", \"ispbifDebtd\":\"" + ispbifDebtd + "\""
        + ", \"vlrLanc\":\"" + vlrLanc + "\""
        + ", \"cnpjNLiqdantDebtd\":\"" + cnpjNLiqdantDebtd + "\""
        + ", \"nomCliDebtd\":\"" + nomCliDebtd + "\""
        + ", \"cnpjNCNPJNLiqdantCredtd\":\"" + cnpjNCNPJNLiqdantCredtd + "\""
        + ", \"nomCliCredtd\":\"" + nomCliCredtd + "\""
        + ", \"tpTranscSlc\":\"" + tpTranscSlc + "\""
        + "}";
  }

}
