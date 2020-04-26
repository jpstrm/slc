package br.com.slc.service;

import br.com.slc.model.GrupoSlcLiquid;
import br.com.slc.repository.GrupoSlcLiquidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Service
public class GrupoSlcLiquidService {

  @Autowired
  private GrupoSlcLiquidRepository grupoSlcLiquidRepository;

  public List<GrupoSlcLiquid> findAll() {

    return grupoSlcLiquidRepository.findAll();
  }
}
