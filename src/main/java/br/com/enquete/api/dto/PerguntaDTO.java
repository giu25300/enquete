package br.com.enquete.api.dto;

import java.io.Serializable;
import java.util.List;

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
public class PerguntaDTO implements Serializable {  
  private static final long serialVersionUID = 5513759770351590135L;
  private Integer codigoPergunta;
  private String descricaoPergunta;
  private Integer codigoPerguntaPai;  
  private TipoPerguntaDTO tipoPergunta;
  
  private List<PerguntaDTO> perguntaDetalhes;
  
//  @JsonProperty("tipoPergunta")
//  private void unpackNested(Integer tipoPergunta_id) {
//      this.tipoPergunta = new TipoPerguntaDTO();
//      tipoPergunta.setCodigoTipoPergunta(tipoPergunta_id);
//  }
}