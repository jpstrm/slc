package br.com.slc.controller.swagger;

import br.com.slc.model.SisMsg;
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
@Api(value = "SisMsg", tags = "SisMsg")
public interface SisMsgApi {

  @ApiOperation(value = "Listar SisMsgs",
      notes = "Operação para listar todas as SisMsgs.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.",
          response = List.class)})
  ResponseEntity<List<SisMsg>> findAll();

}