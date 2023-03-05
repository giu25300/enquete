package br.com.enquete.dominio.entidade;
//package br.com.saneago.enquete.dominio.entidade;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.SequenceGenerator;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name="pergunta_detalhe", schema = "public")
//public class PerguntaDetalhe implements Serializable {  
//  private static final long serialVersionUID = 8774403106011388474L;
//
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @SequenceGenerator(name = "pergunta_detalhe_seq", sequenceName = "public.pergunta_detalhe_seq", allocationSize = 1, schema = "public")
//  @Column(name="cd_perg_detalhe")
//  private Integer codigoPerguntaDetalhe;
//  
//  @ManyToOne(fetch=FetchType.LAZY)
//  @NotNull(message="A pergunta deve ser informada!")
//  @JoinColumn(name="cd_perg", nullable=false)  
//  private Pergunta pergunta;
//  
//  @NotNull(message="Campo descrição do tipo da pergunta detalhe não pode ser nulo!")
//  @Size(max = 100, message = "Descrição do tipo da pergunta detalhe tem o tamanho máximo de 100 caracteres")
//  @Column(name="ds_perg_detalhe", nullable=false)
//  private String descricaoPerguntaDetalhe;
//}