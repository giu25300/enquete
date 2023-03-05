package br.com.enquete.dominio.servico;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.enquete.api.dto.PerguntaDTO;
import br.com.enquete.api.dto.PerguntasEnqueteDTO;
import br.com.enquete.dominio.entidade.Pergunta;
import br.com.enquete.dominio.entidade.PerguntasEnquete;
import br.com.enquete.dominio.repositorio.PerguntaRepository;
import br.com.enquete.dominio.repositorio.PerguntasEnqueteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PerguntaEnqueteService extends BaseService2<PerguntasEnqueteDTO, PerguntasEnquete> {

  private PerguntasEnqueteRepository repository;
  private PerguntaRepository perguntaRepository; 

  @Autowired
  private ModelMapper mapper;

  public PerguntaEnqueteService(PerguntasEnqueteRepository repository,
      PerguntaRepository perguntaRepository) {
    super(repository, PerguntasEnqueteDTO.class, PerguntasEnquete.class);
    this.repository = repository;
    this.perguntaRepository=perguntaRepository;
  }

  public PerguntasEnqueteRepository getRepository() {
    return repository;
  }

  public void setRepository(PerguntasEnqueteRepository repository) {
    this.repository = repository;
  }

  public List<PerguntasEnqueteDTO> listarPerguntas(Integer codigoEnquete) {
    List<PerguntasEnqueteDTO> retorno = mapAllToDTO(repository.listarPerguntas(codigoEnquete), PerguntasEnqueteDTO.class);
    retorno.forEach(e -> {
      
      List<Pergunta> listaPerguntaDetalhes = perguntaRepository.listarPorPergunta(e.getPergunta().getCodigoPergunta());
      
//      List<Pergunta> listaPerguntaDetalhes = perguntaRepository.findBypergunta_codigoPergunta(e.getPergunta().getCodigoPergunta());

      e.getPergunta().setPerguntaDetalhes(listaPerguntaDetalhes.stream().map(entity -> modelMapper().map(entity, PerguntaDTO.class)).collect(Collectors.toList()));
    });

    return retorno;
  } 
}