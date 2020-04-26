package br.com.slc.service;

import br.com.slc.model.GrupoSlcProdt;
import br.com.slc.repository.GrupoSlcProdtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Service
public class GrupoSlcProdtService {

  @Autowired
  private GrupoSlcProdtRepository grupoSlcProdtRepository;

  public List<GrupoSlcProdt> findAll() {

    return grupoSlcProdtRepository.findAll();
  }
}
