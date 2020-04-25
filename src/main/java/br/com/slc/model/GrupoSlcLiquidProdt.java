package br.com.slc.model;

import javax.persistence.Entity;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSlcLiquidProdt extends AbstractModel {

  private Double identdLinhaBilat;

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

  public Double getIdentdLinhaBilat() {
    return identdLinhaBilat;
  }

  public void setIdentdLinhaBilat(Double identdLinhaBilat) {
    this.identdLinhaBilat = identdLinhaBilat;
  }

  public char getTpDebCred() {
    return tpDebCred;
  }

  public void setTpDebCred(char tpDebCred) {
    this.tpDebCred = tpDebCred;
  }

  public Long getIspbifcCredtd() {
    return ispbifcCredtd;
  }

  public void setIspbifcCredtd(Long ispbifcCredtd) {
    this.ispbifcCredtd = ispbifcCredtd;
  }

  public Long getIspbifDebtd() {
    return ispbifDebtd;
  }

  public void setIspbifDebtd(Long ispbifDebtd) {
    this.ispbifDebtd = ispbifDebtd;
  }

  public BigDecimal getVlrLanc() {
    return vlrLanc;
  }

  public void setVlrLanc(BigDecimal vlrLanc) {
    this.vlrLanc = vlrLanc;
  }

  public Long getCnpjNLiqdantDebtd() {
    return cnpjNLiqdantDebtd;
  }

  public void setCnpjNLiqdantDebtd(Long cnpjNLiqdantDebtd) {
    this.cnpjNLiqdantDebtd = cnpjNLiqdantDebtd;
  }

  public String getNomCliDebtd() {
    return nomCliDebtd;
  }

  public void setNomCliDebtd(String nomCliDebtd) {
    this.nomCliDebtd = nomCliDebtd;
  }

  public Long getCnpjNCNPJNLiqdantCredtd() {
    return cnpjNCNPJNLiqdantCredtd;
  }

  public void setCnpjNCNPJNLiqdantCredtd(Long cnpjNCNPJNLiqdantCredtd) {
    this.cnpjNCNPJNLiqdantCredtd = cnpjNCNPJNLiqdantCredtd;
  }

  public String getNomCliCredtd() {
    return nomCliCredtd;
  }

  public void setNomCliCredtd(String nomCliCredtd) {
    this.nomCliCredtd = nomCliCredtd;
  }

  public String getTpTranscSlc() {
    return tpTranscSlc;
  }

  public void setTpTranscSlc(String tpTranscSlc) {
    this.tpTranscSlc = tpTranscSlc;
  }

  @Override
  public String toString() {
    return "{\"GrupoSlcLiquidProdt\":"
        + super.toString()
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
