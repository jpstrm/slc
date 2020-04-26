package br.com.slc.service;

import br.com.slc.model.GrupoSeq;
import br.com.slc.repository.GrupoSeqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Service
public class GrupoSeqService {

  @Autowired
  private GrupoSeqRepository grupoSeqRepository;

  public List<GrupoSeq> findAll() {

    return grupoSeqRepository.findAll();
  }
}
