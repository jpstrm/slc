package br.com.slc.controller;

import br.com.slc.controller.swagger.SlcApi;
import br.com.slc.model.Slc;
import br.com.slc.service.SlcService;
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
@RequestMapping(value = "/slcs", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class SlcController implements SlcApi {

  private Logger logger = LoggerFactory.getLogger(SlcController.class);

  @Autowired
  private SlcService slcService;

  @Override
  @GetMapping
  public ResponseEntity<List<Slc>> findAll() {
    logger.info("GET /slcs");
    final List<Slc> slcs = slcService.findAll();
    logger.info("GET /slcs - success.");

    return ResponseEntity.status(HttpStatus.OK)
        .body(slcs);
  }

}
