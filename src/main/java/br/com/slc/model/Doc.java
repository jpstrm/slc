package br.com.slc.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * @author João Paulo Santarém
 */
@Entity
public class Doc extends AbstractModel {

  private String xmlns;

  @OneToOne(fetch = FetchType.LAZY, targetEntity = Bcmsg.class)
  private Bcmsg bcmsg;

  @OneToOne(fetch = FetchType.LAZY, targetEntity = SisMsg.class)
  private SisMsg sismsg;

  public Doc() {
  }

  public String getXmlns() {
    return xmlns;
  }

  public void setXmlns(String xmlns) {
    this.xmlns = xmlns;
  }

  public Bcmsg getBcmsg() {
    return bcmsg;
  }

  public void setBcmsg(Bcmsg bcmsg) {
    this.bcmsg = bcmsg;
  }

  public SisMsg getSismsg() {
    return sismsg;
  }

  public void setSismsg(SisMsg sismsg) {
    this.sismsg = sismsg;
  }

  @Override
  public String toString() {
    return "{\"Doc\":"
        + super.toString()
        + ", \"xmlns\":\"" + xmlns + "\""
        + ", \"bcmsg\":" + bcmsg
        + ", \"sismsg\":" + sismsg
        + "}";
  }

}
