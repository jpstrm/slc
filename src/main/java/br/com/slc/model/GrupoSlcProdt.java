package br.com.slc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSlcProdt extends AbstractModel {

  private String codProdt;

  @OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private List<GrupoSlcLiquidProdt> grupoSlcLiquidProdts;

  public GrupoSlcProdt() {
  }

  public String getCodProdt() {
    return codProdt;
  }

  @JsonProperty("CodProdt")
  public void setCodProdt(String codProdt) {
    this.codProdt = codProdt;
  }

  public List<GrupoSlcLiquidProdt> getGrupoSlcLiquidProdts() {
    return grupoSlcLiquidProdts;
  }

  @JsonProperty("Grupo_SLC0001_LiquidProdt")
  @JacksonXmlElementWrapper(useWrapping = false)
  public void setGrupoSlcLiquidProdts(List<GrupoSlcLiquidProdt> grupoSlcLiquidProdts) {
    this.grupoSlcLiquidProdts = grupoSlcLiquidProdts;
  }

  @Override
  public String toString() {
    return "{\"GrupoSlcProdt\":"
        + ", \"codProdt\":\"" + codProdt + "\""
        + ", \"grupoSlcLiquidProdts\":" + grupoSlcLiquidProdts
        + "}";
  }

}
