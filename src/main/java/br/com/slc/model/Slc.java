package br.com.slc.model;

import br.com.slc.helper.localdate.LocalDateDeserializer;
import br.com.slc.helper.localdate.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static br.com.slc.helper.localdate.DatePatternConst.DATE_PATTERN;
import static br.com.slc.helper.localdate.DatePatternConst.DATE_TIME_PATTERN;

/**
 * @author João Paulo Santarém
 */
@Entity
public class Slc extends AbstractModel {

  private String codMsg;

  private BigInteger numCtrlSLC;

  private String ispBif;

  private char tpInf;

  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private GrupoSlcLiquid grupoSlcLiquid;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
  private LocalDateTime dtHrSlc;

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
  private LocalDate dtMovto;

  public Slc() {
  }

  public String getCodMsg() {
    return codMsg;
  }

  @JsonProperty("CodMsg")
  public void setCodMsg(String codMsg) {
    this.codMsg = codMsg;
  }

  public BigInteger getNumCtrlSLC() {
    return numCtrlSLC;
  }

  @JsonProperty("NumCtrlSLC")
  public void setNumCtrlSLC(BigInteger numCtrlSLC) {
    this.numCtrlSLC = numCtrlSLC;
  }

  public String getIspBif() {
    return ispBif;
  }

  @JsonProperty("ISPBIF")
  public void setIspBif(String ispBif) {
    this.ispBif = ispBif;
  }

  public char getTpInf() {
    return tpInf;
  }

  @JsonProperty("TpInf")
  public void setTpInf(char tpInf) {
    this.tpInf = tpInf;
  }

  public GrupoSlcLiquid getGrupoSlcLiquid() {
    return grupoSlcLiquid;
  }

  @JsonProperty("Grupo_SLC0001_Liquid")
  public void setGrupoSlcLiquid(GrupoSlcLiquid grupoSlcLiquid) {
    this.grupoSlcLiquid = grupoSlcLiquid;
  }

  public LocalDateTime getDtHrSlc() {
    return dtHrSlc;
  }

  @JsonProperty("DtHrSLC")
  public void setDtHrSlc(LocalDateTime dtHrSlc) {
    this.dtHrSlc = dtHrSlc;
  }

  @JsonProperty("DtMovto")
  public LocalDate getDtMovto() {
    return dtMovto;
  }

  public void setDtMovto(LocalDate dtMovto) {
    this.dtMovto = dtMovto;
  }

  @Override
  public String toString() {
    return "{\"Slc\":{"
        + "\"codMsg\":\"" + codMsg + "\""
        + ", \"numCtrlSLC\":\"" + numCtrlSLC + "\""
        + ", \"ispBif\":\"" + ispBif + "\""
        + ", \"tpInf\":\"" + tpInf + "\""
        + ", \"grupoSlcLiquid\":" + grupoSlcLiquid
        + ", \"dtHrSlc\":" + dtHrSlc
        + ", \"dtMovto\":" + dtMovto
        + "}}";
  }

}
