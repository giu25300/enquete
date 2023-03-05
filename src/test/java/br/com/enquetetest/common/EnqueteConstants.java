package br.com.enquetetest.common;

import java.time.LocalDateTime;

import br.com.enquete.dominio.entidade.Enquete;

public class EnqueteConstants {
  public static final Enquete ENQUETE = new Enquete(1,"AÇÃO DA ENGENHARIA","mex9856",LocalDateTime.parse("2022-03-01 08:00:00"),LocalDateTime.parse("2022-04-01 08:00:00"),"A");
  public static final Enquete INVALID_ENQUETE = new Enquete(0,"AÇÃO DA ENGENHARIA","mex9856",LocalDateTime.parse("2022-03-01 08:00:00"),LocalDateTime.parse("2022-04-01 08:00:00"),"A");
}