package br.com.slc.controller;

import br.com.slc.controller.swagger.DocUploadApi;
import br.com.slc.service.DocUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author João Paulo Santarém
 */
@RestController
@RequestMapping(value = "/docs")
public class DocUploadController implements DocUploadApi {

  private Logger logger = LoggerFactory.getLogger(DocUploadController.class);

  @Autowired
  private DocUploadService docUploadService;

  @Override
  @GetMapping(value = "/upload")
  public ResponseEntity<String> upload(@RequestParam MultipartFile file) {
    logger.info("GET /upload - {}", file.getOriginalFilename());
    docUploadService.upload(file);
    logger.info("GET /upload - sucesso: {}", file.getOriginalFilename());


    return ResponseEntity.status(HttpStatus.OK)
        .body("Arquivo carregado com sucesso");
  }

}
