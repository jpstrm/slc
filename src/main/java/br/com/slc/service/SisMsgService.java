package br.com.slc.service;

import br.com.slc.model.SisMsg;
import br.com.slc.repository.SisMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Service
public class SisMsgService {

  @Autowired
  private SisMsgRepository sisMsgRepository;

  public void save(final SisMsg sisMsg) {
    sisMsgRepository.save(sisMsg);
  }

  public List<SisMsg> findAll() {

    return sisMsgRepository.findAll();
  }

}
