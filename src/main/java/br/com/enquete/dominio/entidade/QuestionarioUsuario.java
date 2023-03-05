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
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="questionario_usuario", schema = "public")
public class QuestionarioUsuario implements Serializable {  
  private static final long serialVersionUID = -422255668877425429L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name = "quest_usu_seq", sequenceName = "public.quest_usu_seq", allocationSize = 1, schema = "public")
  @Positive(message="O id do questionario deve ser maior que zero!")
  @Column(name="cd_quest_usu")
  private Integer codigoQuestionarioUsuario;
  
  @NotNull(message="Informe a data de resposta da enquete!")
  @Column(name="dt_quest", nullable=false)
  private LocalDateTime dataQuestionario;
  
  @NotNull(message="Informe a origem da resposta!")
  @Column(name="st_origem", nullable=false)
  private String origem;
  
  @Column(name="nr_matr")
  private String matricula;
}