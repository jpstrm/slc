package br.com.slc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author João Paulo Santarém
 */
@Entity
public class SisMsg extends AbstractModel {

  @NotNull
  @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private Slc slc;

  public SisMsg() {
  }

  public Slc getSlc() {
    return slc;
  }

  @JsonProperty("SLC0001")
  public void setSlc(Slc slc) {
    this.slc = slc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SisMsg)) return false;
    SisMsg sisMsg = (SisMsg) o;
    return slc.equals(sisMsg.slc);
  }

  @Override
  public int hashCode() {
    return Objects.hash(slc);
  }

  @Override
  public String toString() {
    return "{\"SisMsg\":"
        + ", \"slc\":" + slc
        + "}";
  }

}
