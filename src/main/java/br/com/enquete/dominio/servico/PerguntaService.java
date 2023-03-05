package br.com.enquete.dominio.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.enquete.api.dto.PerguntaDTO;
import br.com.enquete.dominio.entidade.Pergunta;
import br.com.enquete.dominio.repositorio.PerguntaRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author giulianors@gmail.com
 * @name Giuliano Rosa da Silva
 */

@Slf4j
@Service
public class PerguntaService extends BaseService2<PerguntaDTO, Pergunta> {
  private PerguntaRepository repository;

  public PerguntaService(PerguntaRepository repository) {
    super(repository, PerguntaDTO.class, Pergunta.class);
    this.repository = repository;
  }

  public PerguntaRepository getRepository() {
    return repository;
  }

  public void setRepository(PerguntaRepository repository) {
    this.repository = repository;
  }

  public PerguntaDTO Inserir(PerguntaDTO perguntaDTO) {
    return super.gravar(perguntaDTO);
  }

  public Pergunta inserir(Pergunta pergunta){
    return super.gravarEntidade(pergunta);
  }

  public PerguntaDTO PesquisaPorId(Integer codigoPergunta){
    return super.buscarPeloId(codigoPergunta);
  }

  public Pergunta pesquisaPorId(Integer codigoPergunta){
    return super.buscarEntitidadePeloId(codigoPergunta);
  }

  public List<PerguntaDTO> ListaPorNome(String descricaoEnquete){
    return super.mapAllToDTO(repository.findByDescricaoPergunta(descricaoEnquete),getDTOClass());
  }

  public List<Pergunta> listaPorNome(String descricaoEnquete){
    return repository.findByDescricaoPergunta(descricaoEnquete);
  }
}