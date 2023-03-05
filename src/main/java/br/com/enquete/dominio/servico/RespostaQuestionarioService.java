package br.com.enquete.dominio.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.enquete.api.dto.PerguntasEnqueteDTO;
import br.com.enquete.api.dto.RespostaQuestionarioDTO;
import br.com.enquete.api.dto.RespostaQuestionarioDTO2;
import br.com.enquete.dominio.entidade.RespostaQuestionario;
import br.com.enquete.dominio.repositorio.RespostaQuestionarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RespostaQuestionarioService extends BaseService2<RespostaQuestionarioDTO, RespostaQuestionario> {
  private RespostaQuestionarioRepository repository;
  
  public RespostaQuestionarioService(RespostaQuestionarioRepository repository) {
    super(repository, RespostaQuestionarioDTO.class, RespostaQuestionario.class); 
    this.repository = repository;
  }

  public RespostaQuestionarioRepository getRepository() {
    return repository;
  }

  public void setRepository(RespostaQuestionarioRepository repository) {
    this.repository = repository;
  }
  
  @Transactional
  public RespostaQuestionarioDTO2 gravar2(RespostaQuestionarioDTO2 entidade) {
    List<RespostaQuestionarioDTO> lista = new ArrayList<RespostaQuestionarioDTO>();
    
    entidade.getRespostaQuestionario().forEach(e-> {
      RespostaQuestionarioDTO r = new RespostaQuestionarioDTO();
      r.setDescricaoResposta(e.getDescricaoResposta().trim());      
      r.setValorResposta(e.getValorResposta());      
      r.setPerguntasEnquete(PerguntasEnqueteDTO.builder().codigoPerguntaEnquete(e.getPerguntasEnquete().getCodigoPerguntaEnquete()).build());
      
      r = super.gravar(r);
      lista.add(r);
    });
    
    entidade.setRespostaQuestionario(lista);
    return entidade;
  }
}