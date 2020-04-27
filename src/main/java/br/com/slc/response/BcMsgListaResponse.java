package br.com.slc.response;

import br.com.slc.model.BcMsg;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "BcMsg Lista Response")
public class BcMsgListaResponse extends BaseResponse<BcMsg> implements Serializable {

  public BcMsgListaResponse(final List<BcMsg> elementos) {
    super(elementos);
  }

}
