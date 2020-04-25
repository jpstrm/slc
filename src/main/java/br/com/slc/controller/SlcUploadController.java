package br.com.slc.controller;

import br.com.slc.controller.swagger.SlcUploadApi;
import br.com.slc.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author João Paulo Santarém
 */
@RestController
public class SlcUploadController implements SlcUploadApi {

  private Logger logger = LoggerFactory.getLogger(SlcUploadController.class);

  @Autowired
  FileUploadService fileUploadService;

  @Override
  @GetMapping("/upload")
  public ResponseEntity<String> upload(@RequestParam MultipartFile file) {
    logger.info("GET /upload - {}", file.getOriginalFilename());
    fileUploadService.upload(file);
    logger.info("GET /upload - sucesso: {}", file.getOriginalFilename());


    return ResponseEntity.status(HttpStatus.OK)
        .body("Arquivo carregado com sucesso");
  }

}
