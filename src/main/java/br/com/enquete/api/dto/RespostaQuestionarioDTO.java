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
public class RespostaQuestionarioDTO implements Serializable {
  private static final long serialVersionUID = 5964986632971261467L;
  private Integer codigoRespostaQuestionario;
  private String descricaoResposta;
  private Integer valorResposta;
  private PerguntasEnqueteDTO perguntasEnquete;
  private QuestionarioUsuarioDTO questionarioUsuario;  
}