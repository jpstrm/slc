package br.com.slc.controller.swagger;

import br.com.slc.response.GrupoSeqListaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author João Paulo Santarém
 */
@Api(value = "GrupoSeq", tags = "GrupoSeq")
public interface GrupoSeqApi {

  @ApiOperation(value = "Listar GrupoSeqs",
      notes = "Operação para listar todos os GrupoSeqs.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = GrupoSeqListaResponse.class)})
  ResponseEntity<GrupoSeqListaResponse> findAll();

}
