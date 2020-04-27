package br.com.slc.response;

import br.com.slc.model.GrupoSlcProdt;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "BcMsg Lista Response")
public class GrupoSlcProdtListaResponse extends BaseResponse<GrupoSlcProdt> implements Serializable {

  public GrupoSlcProdtListaResponse(final List<GrupoSlcProdt> elementos) {
    super(elementos);
  }

}
