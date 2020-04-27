package br.com.slc.response;

import br.com.slc.model.Slc;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "Slc Lista Response")
public class SlcListaResponse extends BaseResponse<Slc> {

  public SlcListaResponse(List<Slc> elementos) {
    super(elementos);
  }

}
