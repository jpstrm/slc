package br.com.slc.request;

import br.com.slc.model.BcMsg;
import br.com.slc.model.SisMsg;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "SLC XML request")
public class SlcXmlRequest {

  private BcMsg bcmsg;

  private SisMsg sisMsg;

  public SlcXmlRequest() {
  }

  public BcMsg getBcmsg() {
    return bcmsg;
  }

  @JsonProperty("BCMSG")
  public void setBcmsg(BcMsg bcmsg) {
    this.bcmsg = bcmsg;
  }

  public SisMsg getSisMsg() {
    return sisMsg;
  }

  @JsonProperty("SISMSG")
  public void setSisMsg(SisMsg sisMsg) {
    this.sisMsg = sisMsg;
  }

  @Override
  public String toString() {
    return "{\"SlcXmlRequest\":{"
        + "\"bcmsg\":" + bcmsg
        + ", \"sisMsg\":" + sisMsg
        + "}}";
  }

}
