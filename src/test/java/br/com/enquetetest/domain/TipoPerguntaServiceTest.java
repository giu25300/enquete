package br.com.enquetetest.domain;

import static br.com.enquetetest.common.TipoPerguntaConstants.INVALID_TIPOPERGUNTA;
import static br.com.enquetetest.common.TipoPerguntaConstants.TIPOPERGUNTA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.enquete.dominio.entidade.TipoPergunta;
import br.com.enquete.dominio.repositorio.TipoPerguntaRepository;
import br.com.enquete.dominio.servico.TipoPerguntaService;

/**
 * @author giulianors@gmail.com
 * @name Giuliano Rosa da Silva
 */

@ExtendWith(MockitoExtension.class)
public class TipoPerguntaServiceTest {
  @InjectMocks
  private TipoPerguntaService tipoPerguntaService;

  @Mock
  private TipoPerguntaRepository tipoPerguntaRepository;

  @Test
  public void createTipoPergunta_WithValidData_ReturnsTipoPergunta() {
    when(tipoPerguntaRepository.save(TIPOPERGUNTA)).thenReturn(TIPOPERGUNTA);

    TipoPergunta sut = tipoPerguntaService.inserir(TIPOPERGUNTA);

    assertThat(sut).isEqualTo(TIPOPERGUNTA);
  }

  @Test
  public void createTipoPegunta_WithIvalidData_ThrowsException() {
    when(tipoPerguntaRepository.save(INVALID_TIPOPERGUNTA)).thenThrow(RuntimeException.class);

    assertThatThrownBy(()->tipoPerguntaService.inserir(INVALID_TIPOPERGUNTA)).isInstanceOf(RuntimeException.class);
  }

  @Test
  public void getTipoPergunta_ByExistingId_ReturnsTipoPergunta() {

  }

  @Test
  public void getTipoPergunta_ByUnexistingId_ReturnsEmpty() {

  }
}
