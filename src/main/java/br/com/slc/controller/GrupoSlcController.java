package br.com.slc.controller;

import br.com.slc.controller.swagger.GrupoSlcApi;
import br.com.slc.model.GrupoSlcLiquid;
import br.com.slc.model.GrupoSlcLiquidProdt;
import br.com.slc.model.GrupoSlcProdt;
import br.com.slc.service.GrupoSlcService;
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
@RequestMapping(value = "/grupo-slc", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
public class GrupoSlcController implements GrupoSlcApi {

  private Logger logger = LoggerFactory.getLogger(GrupoSlcController.class);

  @Autowired
  private GrupoSlcService grupoSlcService;

  @Override
  @GetMapping("/liquids")
  public ResponseEntity<List<GrupoSlcLiquid>> findAllGrupoSlcLiquid() {
    logger.info("GET /grupo-slc/liquids");
    final List<GrupoSlcLiquid> grupoSlcLiquids = grupoSlcService.findAllGrupoSlcLiquid();
    logger.info("GET /grupo-slc/liquids - success.");

    return ResponseEntity.status(HttpStatus.OK)
        .body(grupoSlcLiquids);
  }

  @Override
  @GetMapping("/prodts")
  public ResponseEntity<List<GrupoSlcProdt>> findAllGrupoSlcProdt() {
    logger.info("GET /grupo-slc/prodts");
    final List<GrupoSlcProdt> grupoSlcLiquidProdts = grupoSlcService.findAllGrupoSlcProdt();
    logger.info("GET /grupo-slc/prodts - success.");

    return ResponseEntity.status(HttpStatus.OK)
        .body(grupoSlcLiquidProdts);
  }

  @Override
  @GetMapping("/liquids/prodts")
  public ResponseEntity<List<GrupoSlcLiquidProdt>> findAllGrupoSlcLiquidProdt() {
    logger.info("GET /grupo-slc/liquid/prodts");
    final List<GrupoSlcLiquidProdt> grupoSlcLiquidProdts = grupoSlcService.findAllGrupoSlcLiquidProdt();
    logger.info("GET /grupo-slc/liquid/prodts - success.");

    return ResponseEntity.status(HttpStatus.OK)
        .body(grupoSlcLiquidProdts);
  }

}
