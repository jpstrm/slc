package br.com.slc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author João Paulo Santarém
 */
@Entity
public class BcMsg extends AbstractModel implements Serializable {

  final static long serialVersionUID = 4190558187878833419L;

  @NotNull
  @Column(nullable = false)
  private Long identdEmissor;

  @NotNull
  @Column(nullable = false)
  private Long identdDestinatario;

  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, optional = false)
  private GrupoSeq grupoSeqs;

  @NotBlank
  @Column(nullable = false)
  private String domSist;

  @NotBlank
  @Column(nullable = false)
  private String nUOp;

  public BcMsg() {
  }

  public Long getIdentdEmissor() {
    return identdEmissor;
  }

  @JsonProperty(value = "IdentdEmissor")
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

  public String getnUOp() {
    return nUOp;
  }

  @JsonProperty("NUOp")
  public void setnUOp(String nUOp) {
    this.nUOp = nUOp;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BcMsg)) return false;
    BcMsg bcMsg = (BcMsg) o;
    return identdEmissor.equals(bcMsg.identdEmissor) &&
        identdDestinatario.equals(bcMsg.identdDestinatario) &&
        grupoSeqs.equals(bcMsg.grupoSeqs) &&
        domSist.equals(bcMsg.domSist) &&
        nUOp.equals(bcMsg.nUOp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identdEmissor, identdDestinatario, grupoSeqs, domSist, nUOp);
  }

  @Override
  public String toString() {
    return "{\"BcMsg\":{"
        + "\"identdEmissor\":\"" + identdEmissor + "\""
        + ", \"identdDestinatario\":\"" + identdDestinatario + "\""
        + ", \"grupoSeqs\":" + grupoSeqs
        + ", \"domSist\":\"" + domSist + "\""
        + ", \"nUOp\":\"" + nUOp + "\""
        + "}}";
  }

}
