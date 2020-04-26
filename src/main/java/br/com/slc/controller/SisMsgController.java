package br.com.slc.controller;

import br.com.slc.controller.swagger.SisMsgApi;
import br.com.slc.model.SisMsg;
import br.com.slc.service.SisMsgService;
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
@RequestMapping(value = "/sismsgs", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class SisMsgController implements SisMsgApi {

  private Logger logger = LoggerFactory.getLogger(SisMsgController.class);

  @Autowired
  private SisMsgService sisMsgService;

  @Override
  @GetMapping
  public ResponseEntity<List<SisMsg>> findAll() {
    logger.info("GET /sismsgs");
    final List<SisMsg> sisMsgs = sisMsgService.findAll();
    logger.info("GET /sismsgs - success.");

    return ResponseEntity.status(HttpStatus.OK)
        .body(sisMsgs);
  }

}
