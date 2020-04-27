package br.com.slc.response;

import br.com.slc.model.GrupoSlcLiquid;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "BcMsg Lista Response")
public class GrupoSlcLiquidListaResponse extends BaseResponse<GrupoSlcLiquid> implements Serializable {

  public GrupoSlcLiquidListaResponse(final List<GrupoSlcLiquid> elementos) {
    super(elementos);
  }

}
