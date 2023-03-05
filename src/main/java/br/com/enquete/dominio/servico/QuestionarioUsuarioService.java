package br.com.enquete.dominio.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.enquete.api.dto.QuestionarioUsuarioDTO;
import br.com.enquete.api.dto.RespostaQuestionarioDTO;
import br.com.enquete.api.dto.RespostaQuestionarioDTO2;
import br.com.enquete.dominio.entidade.QuestionarioUsuario;
import br.com.enquete.dominio.repositorio.QuestionarioUsuarioRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class QuestionarioUsuarioService extends BaseService2<QuestionarioUsuarioDTO, QuestionarioUsuario> {
  private RespostaQuestionarioService serviceRespostaQuestionario;
  
  private QuestionarioUsuarioRepository repository;  
  
  @Autowired
  public QuestionarioUsuarioService(QuestionarioUsuarioRepository repository, RespostaQuestionarioService serviceRespostaQuestionario) {
    super(repository, QuestionarioUsuarioDTO.class, QuestionarioUsuario.class); 
    this.repository = repository;
    this.serviceRespostaQuestionario=serviceRespostaQuestionario;
  }

  public QuestionarioUsuarioRepository getRepository() {
    return repository;
  }

  public void setRepository(QuestionarioUsuarioRepository repository) {
    this.repository = repository;
  }
  
  @Transactional
  public RespostaQuestionarioDTO2 insereQuestionario(RespostaQuestionarioDTO2 objeto) {
    try {
      final RespostaQuestionarioDTO2 saida = new RespostaQuestionarioDTO2();
      
      QuestionarioUsuarioDTO questionarioUsuario = super.gravar(objeto.getQuestionarioUsuario());
      saida.setQuestionarioUsuario(questionarioUsuario);
      
      objeto.getRespostaQuestionario().forEach(e-> {      
        e.setQuestionarioUsuario(questionarioUsuario);      
      });
      
      List<RespostaQuestionarioDTO> lista = serviceRespostaQuestionario.gravarTodos(objeto.getRespostaQuestionario());
      saida.setRespostaQuestionario(lista);
      
      return saida;
    }
    catch (Exception ex) {
      throw ex;
    }    
  }
}