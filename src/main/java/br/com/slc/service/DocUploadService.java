package br.com.slc.service;

import br.com.slc.converter.SlcRequestConverter;
import br.com.slc.exception.BadRequestException;
import br.com.slc.request.SlcXmlRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author João Paulo Santarém
 */
@Service
public class DocUploadService {

  private Logger logger = LoggerFactory.getLogger(DocUploadService.class);

  @Autowired
  private SlcRequestConverter slcRequestConverter;

  @Autowired
  private BcMsgService bcMsgService;

  @Autowired
  private SisMsgService sisMsgService;

  public void upload(final MultipartFile multipartFile) {

    try {
      SlcXmlRequest slcXmlRequest = slcRequestConverter.fromXmlFile(multipartFile);

      bcMsgService.save(slcXmlRequest.getBcmsg());
      sisMsgService.save(slcXmlRequest.getSisMsg());
    } catch (IOException e) {
      logger.error("Erro ao ler arquivo xml: {} - {}", multipartFile.getOriginalFilename(), e.getLocalizedMessage());
      throw new BadRequestException("Arquivo xml corrompido ou inválido - " + e.getLocalizedMessage());
    }
  }

}
