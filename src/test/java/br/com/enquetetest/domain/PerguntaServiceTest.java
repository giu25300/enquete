package br.com.enquetetest.domain;

import static br.com.enquetetest.common.PerguntaConstants.INVALID_PERGUNTA;
import static br.com.enquetetest.common.PerguntaConstants.PERGUNTA;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.enquete.dominio.entidade.Pergunta;
import br.com.enquete.dominio.repositorio.PerguntaRepository;
import br.com.enquete.dominio.servico.PerguntaService;

/**
 * @author giulianors@gmail.com
 * @name Giuliano Rosa da Silva
 */

@ExtendWith(MockitoExtension.class)
public class PerguntaServiceTest {
  @InjectMocks
  private PerguntaService perguntaService;

  @Mock
  private PerguntaRepository perguntaRepository;

  @Test
  public void createPergunta_WithValidaData_ReturnsPergunta(){
    when(perguntaRepository.save(PERGUNTA)).thenReturn(PERGUNTA);

    Pergunta sut = perguntaService.inserir(PERGUNTA);

    assertThat(sut).isEqualTo(PERGUNTA);
  }

  @Test
  public void createPergunta_WithInvalidData_ThrowsException(){
    when(perguntaRepository.save(INVALID_PERGUNTA)).thenThrow(RuntimeException.class);

    assertThatThrownBy(() -> perguntaService.inserir(INVALID_PERGUNTA)).isInstanceOf(RuntimeException.class);
  }

  @Test
  public void getPergunta_ByExistingId_ReturnsTipoPergunta() {
    when(perguntaRepository.findById(PERGUNTA.getCodigoPergunta())).thenReturn(Optional.of(PERGUNTA));

    Pergunta sut = perguntaService.pesquisaPorId(PERGUNTA.getCodigoPergunta());

    assertThat(sut).isNotNull();
    assertThat(sut).isEqualTo(PERGUNTA);
  }

  @Test
  public void getPergunta_ByUnexistingId_ThrowsException() {
    when(perguntaRepository.findById(INVALID_PERGUNTA.getCodigoPergunta())).thenThrow(RuntimeException.class);

    assertThatThrownBy(() -> perguntaService.pesquisaPorId(INVALID_PERGUNTA.getCodigoPergunta())).isInstanceOf(RuntimeException.class);
  }
}
