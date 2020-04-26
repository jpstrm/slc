package br.com.slc.controller.swagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author João Paulo Santarém
 */
@Api(value = "SlcUpload", tags = "SLC")
public interface DocUploadApi {

  @ApiOperation(value = "Upload do arquivo SLC",
      notes = "Operação para realizar upload do arquivo SLC no formato XML.",
      consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
  @ApiResponses({
      @ApiResponse(code = 200, message = "Requisição realizada com sucesso.",
          response = Void.class)})
  ResponseEntity<String> upload(@RequestParam MultipartFile file);

}
