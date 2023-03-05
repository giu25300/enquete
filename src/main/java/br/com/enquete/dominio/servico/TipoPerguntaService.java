package br.com.enquete.dominio.servico;

import org.springframework.stereotype.Service;

import br.com.enquete.api.dto.TipoPerguntaDTO;
import br.com.enquete.dominio.entidade.TipoPergunta;
import br.com.enquete.dominio.repositorio.TipoPerguntaRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author giulianors@gmail.com
 * @name Giuliano Rosa da Silva
 */
@Slf4j
@Service
public class TipoPerguntaService extends BaseService2<TipoPerguntaDTO, TipoPergunta> {
  private TipoPerguntaRepository repository;

  public TipoPerguntaService(TipoPerguntaRepository repository) {
    super(repository, TipoPerguntaDTO.class, TipoPergunta.class);
    this.repository = repository;
  }

  public TipoPerguntaRepository getRepository() {
    return repository;
  }

  public void setRepository(TipoPerguntaRepository repository) {
    this.repository = repository;
  }

  public TipoPerguntaDTO Inserir(TipoPerguntaDTO tipoPerguntaDTO) {
    return gravar(tipoPerguntaDTO);
  }

  public TipoPergunta inserir(TipoPergunta tipoPergunta) {
    return super.gravarEntidade(tipoPergunta);
  }

  public TipoPerguntaDTO PesquisaPeloId(Integer codigoTipoPergunta){
    return super.buscarPeloId(codigoTipoPergunta);
  }

  public TipoPergunta pesquisaPeloId(Integer codigoTipoPergunta){
    return super.buscarEntitidadePeloId(codigoTipoPergunta);
  }
}