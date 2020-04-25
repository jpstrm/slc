package br.com.slc.model;

import javax.persistence.Entity;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSeq extends AbstractModel {

  private Long numSeq;

  private char indrCont;

  public GrupoSeq() {
  }

  public Long getNumSeq() {
    return numSeq;
  }

  public void setNumSeq(Long numSeq) {
    this.numSeq = numSeq;
  }

  public char getIndrCont() {
    return indrCont;
  }

  public void setIndrCont(char indrCont) {
    this.indrCont = indrCont;
  }

  @Override
  public String toString() {
    return "{\"GrupoSeq\":"
        + super.toString()
        + ", \"numSeq\":\"" + numSeq + "\""
        + ", \"indrCont\":\"" + indrCont + "\""
        + "}";
  }

}
