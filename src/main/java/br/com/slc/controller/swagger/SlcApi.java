package br.com.slc.controller.swagger;

import br.com.slc.model.Slc;
import br.com.slc.response.SlcListaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author João Paulo Santarém
 */
@Api(value = "Slc", tags = "SLC")
public interface SlcApi {

  @ApiOperation(value = "Listar SLCs",
      notes = "Operação para listar todas as SLCs.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = SlcListaResponse.class)})
  ResponseEntity<SlcListaResponse> findAll();

  @ApiOperation(value = "Busca SLC por CodMsg",
      notes = "Operação para buscar uma SLC por CodMsg.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = Slc.class)})
  ResponseEntity<Slc> findByCodMsg(@ApiParam(value = "Cod msg") @PathVariable String codMsg);

}
