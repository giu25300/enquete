package br.com.enquete.api.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class TipoPerguntaDTO implements Serializable  {  
  private static final long serialVersionUID = 1959290191736136249L;
  private Integer codigoTipoPergunta;
  private String descricaoTipoPergunta;
}
