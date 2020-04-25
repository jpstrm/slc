package br.com.slc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author João Paulo Santarém
 */
@Entity
public class SisMsg extends AbstractModel {

  @OneToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private Slc slc;

  public SisMsg() {
  }

  public Slc getSlc() {
    return slc;
  }

  public void setSlc(Slc slc) {
    this.slc = slc;
  }

  @Override
  public String toString() {
    return "{\"SisMsg\":"
        + super.toString()
        + ", \"slc\":" + slc
        + "}";
  }

}
