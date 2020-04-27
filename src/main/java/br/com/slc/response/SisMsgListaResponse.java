package br.com.slc.response;

import br.com.slc.model.SisMsg;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "SisMsg Lista Response")
public class SisMsgListaResponse extends BaseResponse<SisMsg> {

  public SisMsgListaResponse(final List<SisMsg> elementos) {
    super(elementos);
  }

}
