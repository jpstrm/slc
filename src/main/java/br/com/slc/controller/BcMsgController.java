package br.com.slc.controller;

import br.com.slc.controller.swagger.BcMsgApi;
import br.com.slc.model.BcMsg;
import br.com.slc.service.BcMsgService;
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
@RequestMapping(value = "/bcmsgs", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class BcMsgController implements BcMsgApi {

  private Logger logger = LoggerFactory.getLogger(BcMsgController.class);

  @Autowired
  private BcMsgService bcMsgService;

  @Override
  @GetMapping
  public ResponseEntity<List<BcMsg>> findAll() {
    logger.info("GET /bcmsgs");
    final List<BcMsg> bcMsgs = bcMsgService.findAll();
    logger.info("GET /bcmsgs - success.");

    return ResponseEntity.status(HttpStatus.OK)
        .body(bcMsgs);
  }

}
