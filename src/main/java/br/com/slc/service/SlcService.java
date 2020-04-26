package br.com.slc.service;

import br.com.slc.model.Slc;
import br.com.slc.repository.SlcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Service
public class SlcService {

  @Autowired
  private SlcRepository slcRepository;

  public List<Slc> findAll() {

    return slcRepository.findAll();
  }

  public void save(final Slc slc) {
    slcRepository.save(slc);
  }

}
