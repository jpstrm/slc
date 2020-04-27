package br.com.slc.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author João Paulo Santarém
 */
public abstract class BaseResponse<T extends Serializable> {

  @ApiModelProperty("Total de elementos")
  private Integer totalElementos;

  @ApiModelProperty("Lista")
  private List<T> elementos;

  BaseResponse() {
  }

  protected BaseResponse(List<T> elementos) {
    this.totalElementos = elementos.size();
    this.elementos = elementos;
  }

  public Integer getTotalElementos() {
    return totalElementos;
  }

  public void setTotalElementos(Integer totalElementos) {
    this.totalElementos = totalElementos;
  }

  public List<T> getElementos() {
    return elementos;
  }

  public void setElementos(List<T> elementos) {
    this.elementos = elementos;
  }

}
