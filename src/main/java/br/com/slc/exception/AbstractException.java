package br.com.slc.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
public class AbstractException extends RuntimeException implements Serializable {

  private static final long serialVersionUID = -6438261965899154186L;
  private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

  public AbstractException(final String msg) {
    super(msg);
  }

  public AbstractException(final String msg, final Throwable throwable) {
    super(msg, throwable);
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

}
