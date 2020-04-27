package br.com.slc.controller.swagger;

import br.com.slc.model.GrupoSlcLiquid;
import br.com.slc.model.GrupoSlcLiquidProdt;
import br.com.slc.model.GrupoSlcProdt;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.")})
  ResponseEntity<List<GrupoSlcLiquid>> findAllGrupoSlcLiquid();

  @ApiOperation(value = "Listar GrupoSlcProdts",
      notes = "Operação para listar todos os GrupoSlcProdts.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.")})
  ResponseEntity<List<GrupoSlcProdt>> findAllGrupoSlcProdt();

  @ApiOperation(value = "Listar GrupoSlcLiquidProdts",
      notes = "Operação para listar todos os GrupoSlcLiquidProdts.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.")})
  ResponseEntity<List<GrupoSlcLiquidProdt>> findAllGrupoSlcLiquidProdt();

}
