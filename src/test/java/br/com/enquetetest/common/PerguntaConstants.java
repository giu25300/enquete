package br.com.enquetetest.common;

import br.com.enquete.dominio.entidade.Pergunta;
import br.com.enquete.dominio.entidade.TipoPergunta;

public class PerguntaConstants {
  public static final Pergunta PERGUNTA = new Pergunta(1,"",null,TipoPergunta.builder().codigoTipoPergunta(1).build(),null);
  public static final Pergunta INVALID_PERGUNTA = new Pergunta(0,"",null,TipoPergunta.builder().codigoTipoPergunta(1).build(), null);
}