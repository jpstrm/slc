package br.com.slc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author João Paulo Santarém
 */
@Entity
public class Slc extends AbstractModel {

  private String codMsg;

  private Double numCtrlSLC;

  private String ispBif;

  private char tpInf;

  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private GrupoSlcLiquid grupoSlcLiquid;

  private LocalDateTime dtHrSlc;

  private LocalDate dtMovto;

  public Slc() {
  }

  public String getCodMsg() {
    return codMsg;
  }

  public void setCodMsg(String codMsg) {
    this.codMsg = codMsg;
  }

  public Double getNumCtrlSLC() {
    return numCtrlSLC;
  }

  public void setNumCtrlSLC(Double numCtrlSLC) {
    this.numCtrlSLC = numCtrlSLC;
  }

  public String getIspBif() {
    return ispBif;
  }

  public void setIspBif(String ispBif) {
    this.ispBif = ispBif;
  }

  public char getTpInf() {
    return tpInf;
  }

  public void setTpInf(char tpInf) {
    this.tpInf = tpInf;
  }

  public GrupoSlcLiquid getGrupoSlcLiquid() {
    return grupoSlcLiquid;
  }

  public void setGrupoSlcLiquid(GrupoSlcLiquid grupoSlcLiquid) {
    this.grupoSlcLiquid = grupoSlcLiquid;
  }

  public LocalDateTime getDtHrSlc() {
    return dtHrSlc;
  }

  public void setDtHrSlc(LocalDateTime dtHrSlc) {
    this.dtHrSlc = dtHrSlc;
  }

  public LocalDate getDtMovto() {
    return dtMovto;
  }

  public void setDtMovto(LocalDate dtMovto) {
    this.dtMovto = dtMovto;
  }

  @Override
  public String toString() {
    return "{\"Slc\":"
        + super.toString()
        + ", \"codMsg\":\"" + codMsg + "\""
        + ", \"numCtrlSLC\":\"" + numCtrlSLC + "\""
        + ", \"ispBif\":\"" + ispBif + "\""
        + ", \"tpInf\":\"" + tpInf + "\""
        + ", \"grupoSlcLiquid\":" + grupoSlcLiquid
        + ", \"dtHrSlc\":" + dtHrSlc
        + ", \"dtMovto\":" + dtMovto
        + "}";
  }

}
