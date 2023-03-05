package br.com.enquete.dominio.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="enquete", schema = "public")
public class Enquete implements Serializable {  
  private static final long serialVersionUID = -422255668877425429L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name = "enquete_seq", sequenceName = "public.enquete_seq", allocationSize = 1, schema = "public")
  @Column(name="cd_enq")
  private Integer codigoEnquete;
  
  @NotNull(message="Informe a descrição da enquete!")
  @Size(max=255, message="Descrição não pode ter mais que 255 caracteres!")
  @Column(name="ds_enq", nullable=false)
  private String descricaoEnquete;
  
  @Size(max=9, message="Matrícula não pode ter mais que 9 caracteres!")
  @Column(name="nr_matr_cad")
  private String matricula;
  
  @NotNull(message="Informe a data de início da enquete!")
  @Column(name="dt_ini")
  private LocalDateTime dataInicio;
  
  @NotNull(message="Informe a data fim da enquete!")
  @Column(name="dt_fim")
  private LocalDateTime dataFim;
  
  @NotNull(message="Informe o Status!")
  @Size(max=1, message="Status não pode ter mais que 1 caractere!")
  @Column(name="st_status")
  private String status;
}