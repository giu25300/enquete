package br.com.enquete.api.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PerguntasEnqueteDTO implements Serializable {  
  private static final long serialVersionUID = -2190183644060794268L;
  private Integer codigoPerguntaEnquete;
  private EnqueteDTO enquete;
  private PerguntaDTO pergunta;  
  private boolean obrigatorio;
  private Integer tamanho;
}