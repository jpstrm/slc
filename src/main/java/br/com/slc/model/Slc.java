package br.com.slc.model;

import br.com.slc.helper.localdate.LocalDateDeserializer;
import br.com.slc.helper.localdate.LocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import static br.com.slc.helper.localdate.DatePatternConst.DATE_PATTERN;
import static br.com.slc.helper.localdate.DatePatternConst.DATE_TIME_PATTERN;

/**
 * @author João Paulo Santarém
 */
@Entity
public class Slc extends AbstractModel implements Serializable {

  final static long serialVersionUID = -3614912887284697947L;

  @NotBlank
  @Column(nullable = false)
  private String codMsg;

  @NotBlank
  @Column(nullable = false)
  private String numCtrlSLC;

  @NotNull
  @Column(nullable = false)
  private Long ispBif;

  @NotNull
  @Column(nullable = false, length = 1)
  private char tpInf;

  @NotNull
  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, optional = false)
  private GrupoSlcLiquid grupoSlcLiquid;

  @NotNull
  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_PATTERN)
  @Column(nullable = false)
  private LocalDateTime dtHrSlc;

  @NotNull
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
  @Column(nullable = false)
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

  public String getNumCtrlSLC() {
    return numCtrlSLC;
  }

  @JsonProperty("NumCtrlSLC")
  public void setNumCtrlSLC(String numCtrlSLC) {
    this.numCtrlSLC = numCtrlSLC;
  }

  public Long getIspBif() {
    return ispBif;
  }

  @JsonProperty("ISPBIF")
  public void setIspBif(Long ispBif) {
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

  public LocalDate getDtMovto() {
    return dtMovto;
  }

  @JsonProperty("DtMovto")
  public void setDtMovto(LocalDate dtMovto) {
    this.dtMovto = dtMovto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Slc)) return false;
    Slc slc = (Slc) o;
    return tpInf == slc.tpInf &&
        codMsg.equals(slc.codMsg) &&
        numCtrlSLC.equals(slc.numCtrlSLC) &&
        ispBif.equals(slc.ispBif) &&
        grupoSlcLiquid.equals(slc.grupoSlcLiquid) &&
        dtHrSlc.equals(slc.dtHrSlc) &&
        dtMovto.equals(slc.dtMovto);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codMsg, numCtrlSLC, ispBif, tpInf, grupoSlcLiquid, dtHrSlc, dtMovto);
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
