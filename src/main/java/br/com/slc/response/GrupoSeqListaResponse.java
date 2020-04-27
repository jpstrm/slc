package br.com.slc.response;

import br.com.slc.model.GrupoSeq;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@ApiModel(description = "GrupoSeq Lista Response")
public class GrupoSeqListaResponse extends BaseResponse<GrupoSeq> {

  public GrupoSeqListaResponse(List<GrupoSeq> elementos) {
    super(elementos);
  }

}
