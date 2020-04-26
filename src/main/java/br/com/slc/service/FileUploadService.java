package br.com.slc.service;

import br.com.slc.exception.BadRequestException;
import br.com.slc.helper.SlcHelper;
import br.com.slc.request.SlcXmlRequest;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author João Paulo Santarém
 */
@Service
public class FileUploadService {

  private Logger logger = LoggerFactory.getLogger(FileUploadService.class);

  public void upload(final MultipartFile multipartFile) {

    XmlMapper xmlMapper = new XmlMapper();
    try {
      String xmlContent = SlcHelper.inputStreamToString(multipartFile.getInputStream());
      SlcXmlRequest slcXmlRequest = xmlMapper.readValue(xmlContent, SlcXmlRequest.class);
      logger.info("{}", slcXmlRequest);
    } catch (IOException e) {
      logger.error("Erro ao ler arquivo xml: {} - {}", multipartFile.getOriginalFilename(), e.getLocalizedMessage());
      throw new BadRequestException("Arquivo xml corrompido ou inválido - " + e.getLocalizedMessage());
    }

  }

}
