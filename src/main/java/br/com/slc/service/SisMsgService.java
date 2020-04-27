package br.com.slc.service;

import br.com.slc.model.SisMsg;
import br.com.slc.repository.SisMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
    if (!sisMsgRepository.exists(Example.of(sisMsg))) {
      sisMsgRepository.save(sisMsg);
    }
  }

  public List<SisMsg> findAll() {

    return sisMsgRepository.findAll();
  }

}
