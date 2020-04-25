package br.com.slc.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * @author João Paulo Santarém
 */
@Entity
public class Bcmsg extends AbstractModel {

  private Long identdEmissor;

  private Long identdDestinatario;

  @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  private GrupoSeq grupoSeqs;

  private String domSist;

  private Double nUOp;

  public Bcmsg() {
  }

  public Long getIdentdEmissor() {
    return identdEmissor;
  }

  public void setIdentdEmissor(Long identdEmissor) {
    this.identdEmissor = identdEmissor;
  }

  public Long getIdentdDestinatario() {
    return identdDestinatario;
  }

  public void setIdentdDestinatario(Long identdDestinatario) {
    this.identdDestinatario = identdDestinatario;
  }

  public GrupoSeq getGrupoSeqs() {
    return grupoSeqs;
  }

  public void setGrupoSeqs(GrupoSeq grupoSeqs) {
    this.grupoSeqs = grupoSeqs;
  }

  public String getDomSist() {
    return domSist;
  }

  public void setDomSist(String domSist) {
    this.domSist = domSist;
  }

  public Double getnUOp() {
    return nUOp;
  }

  public void setnUOp(Double nUOp) {
    this.nUOp = nUOp;
  }

  @Override
  public String toString() {
    return "{\"Bcmsg\":"
        + super.toString()
        + ", \"domSist\":\"" + domSist + "\""
        + ", \"identdDestinatario\":\"" + identdDestinatario + "\""
        + ", \"nUOp\":\"" + nUOp + "\""
        + ", \"identdEmissor\":\"" + identdEmissor + "\""
        + ", \"grupoSeqs\":" + grupoSeqs
        + "}";
  }

}
