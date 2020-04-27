package br.com.slc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author João Paulo Santarém
 */
@Entity
public class GrupoSeq extends AbstractModel implements Serializable {

  final static long serialVersionUID = -2295676646834161116L;

  @NotNull
  @Column(nullable = false)
  private Long numSeq;

  @NotNull
  @Column(nullable = false, length = 1)
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof GrupoSeq)) return false;
    GrupoSeq grupoSeq = (GrupoSeq) o;
    return indrCont == grupoSeq.indrCont &&
        numSeq.equals(grupoSeq.numSeq);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numSeq, indrCont);
  }

  @Override
  public String toString() {
    return "{\"GrupoSeq\":{"
        + "\"numSeq\":\"" + numSeq + "\""
        + ", \"indrCont\":\"" + indrCont + "\""
        + "}}";
  }

}
