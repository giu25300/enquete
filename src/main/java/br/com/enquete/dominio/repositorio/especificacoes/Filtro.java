package br.com.enquete.dominio.repositorio.especificacoes;

import lombok.Data;

@Data
public class Filtro {
  private String field;
  private String type;
  private String operator;
  private Object value;
  private String join;
}
