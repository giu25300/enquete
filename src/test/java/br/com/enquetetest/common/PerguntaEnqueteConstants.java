package br.com.enquetetest.common;

import br.com.enquete.dominio.entidade.Enquete;
import br.com.enquete.dominio.entidade.Pergunta;
import br.com.enquete.dominio.entidade.PerguntasEnquete;

public class PerguntaEnqueteConstants {
  public static final PerguntasEnquete PERGUNTAENQUETE = new PerguntasEnquete(1,Enquete.builder().codigoEnquete(1).build(),
      Pergunta.builder().codigoPergunta(1).build(),false,100);
  public static final PerguntasEnquete INVALID_PERGUNTAENQUETE = new PerguntasEnquete(0,Enquete.builder().codigoEnquete(1).build(),
      Pergunta.builder().codigoPergunta(1).build(),false,100);
}
