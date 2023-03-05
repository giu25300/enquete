package br.com.enquete.dominio.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="pergunta", schema = "public")
public class Pergunta implements Serializable {  
  private static final long serialVersionUID = -7613927420361682717L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name = "pergunta_seq", sequenceName = "public.pergunta_seq", allocationSize = 1, schema = "public")
  @Column(name="cd_perg")
  private Integer codigoPergunta;
  
  @NotNull(message="Informa a descrição da pergunta!")
  @Size(max=255)
  @Column(name="ds_perg", nullable=false)
  private String descricaoPergunta;
  
  @ManyToOne
  @JoinColumn(name="cd_perg_pai", nullable=true)
  private Pergunta perguntaPai;
  
  @ManyToOne
  @Positive(message="Tipo da pergunta deve ser maior que 0")
  @JoinColumn(name="tp_pergunta", nullable=false)
  private TipoPergunta tipoPergunta;
  
  @JsonIgnore  
  @Transient  
  private List<Pergunta> perguntaDetalhes;
}