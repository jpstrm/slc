package br.com.slc.controller.swagger;

import br.com.slc.model.GrupoSlcProdt;
import br.com.slc.response.GrupoSlcLiquidListaResponse;
import br.com.slc.response.GrupoSlcLiquidProdtListaResponse;
import br.com.slc.response.GrupoSlcProdtListaResponse;
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
@Api(value = "GrupoSlcLiquid", tags = "GrupoSlcLiquid")
public interface GrupoSlcApi {

  @ApiOperation(value = "Listar GrupoSlcLiquids",
      notes = "Operação para listar todos os GrupoSlcLiquids.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = GrupoSlcLiquidListaResponse.class)})
  ResponseEntity<GrupoSlcLiquidListaResponse> findAllGrupoSlcLiquid();

  @ApiOperation(value = "Listar GrupoSlcProdts",
      notes = "Operação para listar todos os GrupoSlcProdts.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = GrupoSlcProdtListaResponse.class)})
  ResponseEntity<GrupoSlcProdtListaResponse> findAllGrupoSlcProdt();

  @ApiOperation(value = "Busca GrupoSlcProdts pelo CodProdt",
      notes = "Operação encontrar um GrupoSlcProdt pelo CodProdt.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = GrupoSlcProdt.class)})
  ResponseEntity<GrupoSlcProdt> findGrupoSlcProdtByCodProdt(
      @ApiParam(value = "Cod Prodt") @PathVariable String codProdt);

  @ApiOperation(value = "Listar GrupoSlcLiquidProdts",
      notes = "Operação para listar todos os GrupoSlcLiquidProdts.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.", response = GrupoSlcLiquidProdtListaResponse.class)})
  ResponseEntity<GrupoSlcLiquidProdtListaResponse> findAllGrupoSlcLiquidProdt();

}
