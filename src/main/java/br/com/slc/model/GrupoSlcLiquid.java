package br.com.slc.model;

import br.com.slc.helper.localdate.LocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import static br.com.slc.helper.localdate.DatePatternConst.DATE_PATTERN;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSlcLiquid extends AbstractModel implements Serializable {

  final static long serialVersionUID = -2602339359564225922L;

  @NotNull
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
  @Column(nullable = false)
  private LocalDate dtLiquid;

  @NotNull
  @Column(nullable = false)
  private Integer numSeqCicloLiquid;

  @NotNull
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GrupoSlcLiquid)) return false;
    GrupoSlcLiquid that = (GrupoSlcLiquid) o;
    return dtLiquid.equals(that.dtLiquid) &&
        numSeqCicloLiquid.equals(that.numSeqCicloLiquid) &&
        grupoSlcProdts.equals(that.grupoSlcProdts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dtLiquid, numSeqCicloLiquid, grupoSlcProdts);
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
