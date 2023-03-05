package br.com.enquete.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class QuestionarioUsuarioDTO implements Serializable {  
  private static final long serialVersionUID = 6265953202689798397L;
  
  private Integer codigoQuestionarioUsuario;
  
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  @DateTimeFormat(iso = ISO.DATE_TIME)  
  private LocalDateTime dataQuestionario;
  
  private String origem;
  private String matricula;
}
