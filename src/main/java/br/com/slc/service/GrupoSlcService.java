package br.com.slc.service;

import br.com.slc.exception.NotFoundException;
import br.com.slc.model.GrupoSlcLiquid;
import br.com.slc.model.GrupoSlcLiquidProdt;
import br.com.slc.model.GrupoSlcProdt;
import br.com.slc.repository.GrupoSlcLiquidProdtRepository;
import br.com.slc.repository.GrupoSlcLiquidRepository;
import br.com.slc.repository.GrupoSlcProdtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Service
public class GrupoSlcService {

  @Autowired
  private GrupoSlcLiquidProdtRepository grupoSlcLiquidProdtRepository;

  @Autowired
  private GrupoSlcProdtRepository grupoSlcProdtRepository;

  @Autowired
  private GrupoSlcLiquidRepository grupoSlcLiquidRepository;

  public List<GrupoSlcLiquidProdt> findAllGrupoSlcLiquidProdt() {

    return grupoSlcLiquidProdtRepository.findAll();
  }

  public List<GrupoSlcProdt> findAllGrupoSlcProdt() {

    return grupoSlcProdtRepository.findAll();
  }

  public GrupoSlcProdt findAllGrupoSlcProdtByCodProdt(String codProdt) {
    return grupoSlcProdtRepository.findByCodProdtIgnoreCase(codProdt)
        .orElseThrow(() -> new NotFoundException("Grupo Slc Prodt não encontrado para o CodProdt: " + codProdt));
  }

  public List<GrupoSlcLiquid> findAllGrupoSlcLiquid() {

    return grupoSlcLiquidRepository.findAll();
  }

}
