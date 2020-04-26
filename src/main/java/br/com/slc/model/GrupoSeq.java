package br.com.slc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

  @JsonProperty("NumSeq")
  public void setNumSeq(Long numSeq) {
    this.numSeq = numSeq;
  }

  public char getIndrCont() {
    return indrCont;
  }

  @JsonProperty("IndrCont")
  public void setIndrCont(char indrCont) {
    this.indrCont = indrCont;
  }

  @Override
  public String toString() {
    return "{\"GrupoSeq\":{"
        + "\"numSeq\":\"" + numSeq + "\""
        + ", \"indrCont\":\"" + indrCont + "\""
        + "}}";
  }

}
