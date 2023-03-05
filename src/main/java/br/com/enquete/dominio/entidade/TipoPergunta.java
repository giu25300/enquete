package br.com.enquete.dominio.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import br.com.enquete.api.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tipo_pergunta", schema = "public")
public class TipoPergunta extends BaseDTO {  
  private static final long serialVersionUID = -6501281890293971165L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @SequenceGenerator(name = "tipo_pergunta_seq", sequenceName = "public.tipo_pergunta_seq", allocationSize = 1, schema = "public")
  @Positive(message = "O id TipoPergunta deve ser maior que zero")
  @Column(name="cd_tp_perg")
  private Integer codigoTipoPergunta;
  
  @NotNull(message="Campo descrição do tipo da pergunta não pode ser nulo!")
  @Size(max = 100, message = "Descrição do tipo da pergunta tem o tamanho máximo de 100 caracteres")
  @Column(name="ds_tp_perg", nullable=false)
  private String descricaoTipoPergunta;
}
