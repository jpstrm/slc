package br.com.slc.controller;

import br.com.slc.controller.swagger.GrupoSeqApi;
import br.com.slc.model.GrupoSeq;
import br.com.slc.service.GrupoSeqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author João Paulo Santarém
 */
@RestController
@RequestMapping(value = "/grupo-sec", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class GrupoSeqController implements GrupoSeqApi {

  private Logger logger = LoggerFactory.getLogger(GrupoSeqController.class);

  @Autowired
  private GrupoSeqService grupoSeqService;

  @Override
  @GetMapping
  public ResponseEntity<List<GrupoSeq>> findAll() {
    logger.info("GET /grupo-sec");
    final List<GrupoSeq> grupoSeqs = grupoSeqService.findAll();
    logger.info("GET /grupo-sec - success.");

    return ResponseEntity.status(HttpStatus.OK)
        .body(grupoSeqs);
  }

}
