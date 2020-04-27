package br.com.slc.response;

import br.com.slc.model.GrupoSlcLiquidProdt;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "BcMsg Lista Response")
public class GrupoSlcLiquidProdtListaResponse extends BaseResponse<GrupoSlcLiquidProdt> implements Serializable {

  public GrupoSlcLiquidProdtListaResponse(final List<GrupoSlcLiquidProdt> elementos) {
    super(elementos);
  }

}
