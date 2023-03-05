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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="perguntas_enquete", schema = "public")
public class PerguntasEnquete implements Serializable {  
  private static final long serialVersionUID = 7661858767163161807L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name = "perg_enq_seq", sequenceName = "public.perg_enq_seq", allocationSize = 1, schema = "public")
  @Column(name="cd_perg_enq")
  private Integer codigoPerguntaEnquete;  
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="cd_enq", nullable=false)
  private Enquete enquete;  
  
  @ManyToOne
  @JoinColumn(name="cd_perg", nullable=false)
  private Pergunta pergunta;
  
  @Column(name="st_obrig",columnDefinition = "boolean default false")
  private boolean obrigatorio;
  
  @Column(name="nr_tamanho", nullable=true)
  private Integer tamanho;
}