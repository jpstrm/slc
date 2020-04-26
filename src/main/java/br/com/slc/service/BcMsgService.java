package br.com.slc.service;

import br.com.slc.model.BcMsg;
import br.com.slc.repository.BcMsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author João Paulo Santarém
 */
@Service
public class BcMsgService {

  @Autowired
  private BcMsgRepository bcMsgRepository;

  public void save(final BcMsg bcMsg) {
    bcMsgRepository.save(bcMsg);
  }

  public List<BcMsg> findAll() {

    return bcMsgRepository.findAll();
  }

}
