package br.com.slc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

/**
 * @author João Paulo Santarém
 */
@Entity
public class Bcmsg extends AbstractModel {

  private Long identdEmissor;

  private Long identdDestinatario;

  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })
  private GrupoSeq grupoSeqs;

  private String domSist;

  private BigInteger nUOp;

  public Bcmsg() {
  }

  public Long getIdentdEmissor() {
    return identdEmissor;
  }

  @JsonProperty("IdentdEmissor")
  public void setIdentdEmissor(Long identdEmissor) {
    this.identdEmissor = identdEmissor;
  }

  public Long getIdentdDestinatario() {
    return identdDestinatario;
  }

  @JsonProperty("IdentdDestinatario")
  public void setIdentdDestinatario(Long identdDestinatario) {
    this.identdDestinatario = identdDestinatario;
  }

  public GrupoSeq getGrupoSeqs() {
    return grupoSeqs;
  }

  @JsonProperty("Grupo_Seq")
  public void setGrupoSeqs(GrupoSeq grupoSeqs) {
    this.grupoSeqs = grupoSeqs;
  }

  public String getDomSist() {
    return domSist;
  }

  @JsonProperty("DomSist")
  public void setDomSist(String domSist) {
    this.domSist = domSist;
  }

  public BigInteger getnUOp() {
    return nUOp;
  }

  @JsonProperty("NUOp")
  public void setnUOp(BigInteger nUOp) {
    this.nUOp = nUOp;
  }

  @Override
  public String toString() {
    return "{\"Bcmsg\":{"
        + "\"identdEmissor\":\"" + identdEmissor + "\""
        + ", \"identdDestinatario\":\"" + identdDestinatario + "\""
        + ", \"grupoSeqs\":" + grupoSeqs
        + ", \"domSist\":\"" + domSist + "\""
        + ", \"nUOp\":\"" + nUOp + "\""
        + "}}";
  }

}
