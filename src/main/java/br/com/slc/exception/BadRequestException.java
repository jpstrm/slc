package br.com.slc.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
public class BadRequestException extends AbstractException implements Serializable {

  private static final long serialVersionUID = 9103188666776322865L;

  public BadRequestException(final String msg) {
    super(msg);
  }

  public HttpStatus getHttpStatus() {
    return HttpStatus.BAD_REQUEST;
  }

}
