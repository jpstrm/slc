package br.com.slc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSlcLiquid extends AbstractModel {

  private LocalDate dtLiquid;

  private Long numSeqCicloLiquid;

  @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private Set<GrupoSlcProdt> grupoSlcProdts;

  public GrupoSlcLiquid() {
  }

  public LocalDate getDtLiquid() {
    return dtLiquid;
  }

  public void setDtLiquid(LocalDate dtLiquid) {
    this.dtLiquid = dtLiquid;
  }

  public Long getNumSeqCicloLiquid() {
    return numSeqCicloLiquid;
  }

  public void setNumSeqCicloLiquid(Long numSeqCicloLiquid) {
    this.numSeqCicloLiquid = numSeqCicloLiquid;
  }

  public Set<GrupoSlcProdt> getGrupoSlcProdts() {
    return grupoSlcProdts;
  }

  public void setGrupoSlcProdts(Set<GrupoSlcProdt> grupoSlcProdts) {
    this.grupoSlcProdts = grupoSlcProdts;
  }

  @Override
  public String toString() {
    return "{\"GrupoSlcLiquid\":"
        + super.toString()
        + ", \"dtLiquid\":\"" + dtLiquid + "\""
        + ", \"numSeqCicloLiquid\":\"" + numSeqCicloLiquid + "\""
        + ", \"grupoSlcProdts\":" + grupoSlcProdts
        + "}";
  }

}
