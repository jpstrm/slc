package br.com.slc.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSlcProdt extends AbstractModel implements Serializable {

  final static long serialVersionUID = -7240252525039002957L;

  @NotBlank
  @Column(nullable = false)
  private String codProdt;

  @NotNull
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GrupoSlcProdt)) return false;
    GrupoSlcProdt that = (GrupoSlcProdt) o;
    return codProdt.equals(that.codProdt) &&
        grupoSlcLiquidProdts.equals(that.grupoSlcLiquidProdts);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codProdt, grupoSlcLiquidProdts);
  }

  @Override
  public String toString() {
    return "{\"GrupoSlcProdt\":"
        + ", \"codProdt\":\"" + codProdt + "\""
        + ", \"grupoSlcLiquidProdts\":" + grupoSlcLiquidProdts
        + "}";
  }

}
