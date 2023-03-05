package br.com.enquete.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  @EqualsAndHashCode.Include()  
  private Integer id;

  public BaseDTO() {
  }

  public BaseDTO(Integer id) {
    this.id = id;
  }
}
