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
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnqueteDTO implements Serializable {  
  private static final long serialVersionUID = 8321531347441544692L;
  private Integer codigoEnquete;  
  private String descricaoEnquete;
  private String matricula;
  
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private LocalDateTime dataInicio;
  
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  @DateTimeFormat(iso = ISO.DATE_TIME)
  private LocalDateTime dataFim;
  
  private String status;
}