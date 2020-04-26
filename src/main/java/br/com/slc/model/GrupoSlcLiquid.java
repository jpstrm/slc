package br.com.slc.model;

import br.com.slc.helper.localdate.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

import static br.com.slc.helper.localdate.DatePatternConst.DATE_PATTERN;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSlcLiquid extends AbstractModel {

  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
  private LocalDate dtLiquid;

  private Integer numSeqCicloLiquid;

  @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private List<GrupoSlcProdt> grupoSlcProdts;

  public GrupoSlcLiquid() {
  }

  public LocalDate getDtLiquid() {
    return dtLiquid;
  }

  @JsonProperty("DtLiquid")
  public void setDtLiquid(LocalDate dtLiquid) {
    this.dtLiquid = dtLiquid;
  }

  public Integer getNumSeqCicloLiquid() {
    return numSeqCicloLiquid;
  }

  @JsonProperty("NumSeqCicloLiquid")
  public void setNumSeqCicloLiquid(Integer numSeqCicloLiquid) {
    this.numSeqCicloLiquid = numSeqCicloLiquid;
  }

  public List<GrupoSlcProdt> getGrupoSlcProdts() {
    return grupoSlcProdts;
  }

  @JsonProperty("Grupo_SLC0001_Prodt")
  @JacksonXmlElementWrapper(useWrapping = false)
  public void setGrupoSlcProdts(List<GrupoSlcProdt> grupoSlcProdts) {
    this.grupoSlcProdts = grupoSlcProdts;
  }

  @Override
  public String toString() {
    return "{\"GrupoSlcLiquid\":{"
        + "\"dtLiquid\":" + dtLiquid
        + ", \"numSeqCicloLiquid\":\"" + numSeqCicloLiquid + "\""
        + ", \"grupoSlcProdts\":" + grupoSlcProdts
        + "}}";
  }

}
