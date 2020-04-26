package br.com.slc.service;

import br.com.slc.model.GrupoSlcLiquidProdt;
import br.com.slc.repository.GrupoSlcLiquidProdtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Service
public class GrupoSlcLiquidProdtService {

  @Autowired
  private GrupoSlcLiquidProdtRepository grupoSlcLiquidProdtRepository;

  public List<GrupoSlcLiquidProdt> findAll() {

    return grupoSlcLiquidProdtRepository.findAll();
  }
}
