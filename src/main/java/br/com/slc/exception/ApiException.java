package br.com.slc.exception;

import br.com.slc.exception.error.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.Serializable;

/**
 * @author João Paulo Santarém
 */
public class ApiException extends HttpStatusCodeException implements Serializable {

  private static final long serialVersionUID = -5603660003741702875L;
  private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

  public ApiException(final ApiError apiError) {
    super(apiError.getStatus(), apiError.getMessage());
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

}
