package br.com.enquete.dominio.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="resposta_questionario", schema = "public")
public class RespostaQuestionario implements Serializable {  
  private static final long serialVersionUID = -642094510404453828L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name = "resposta_questionario_seq", sequenceName = "public.resposta_questionario_seq", allocationSize = 1, schema = "public")
  @Column(name="cd_resp_quest")
  protected Integer codigoRespostaQuestionario;  
  
  @Column(name="ds_resposta")
  protected String descricaoResposta;
  
  @Column(name="st_resposta")
  protected Integer valorResposta;
  
  @ManyToOne
  @NotNull(message="Código do questionário do usuário não definido!")
  @JoinColumn(name="cd_quest_usu", referencedColumnName="cd_quest_usu", nullable=false)
  protected QuestionarioUsuario questionarioUsuario;  
  
  @ManyToOne(fetch=FetchType.LAZY)
  @NotNull(message="Pergunta não foi definida!")
  @JoinColumn(name="cd_perg_enq", referencedColumnName="cd_perg_enq", nullable=false)
  protected PerguntasEnquete perguntasEnquete;
}