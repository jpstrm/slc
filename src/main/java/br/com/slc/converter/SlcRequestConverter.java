package br.com.slc.converter;

import br.com.slc.helper.SlcHelper;
import br.com.slc.request.SlcXmlRequest;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author João Paulo Santarém
 */
@Component
public class SlcRequestConverter {

  public SlcXmlRequest fromXmlFile(final MultipartFile multipartFile) throws IOException {
    XmlMapper xmlMapper = new XmlMapper();
    String xmlContent = SlcHelper.inputStreamToString(multipartFile.getInputStream());

    return xmlMapper.readValue(xmlContent, SlcXmlRequest.class);
  }
}
