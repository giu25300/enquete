package br.com.enquete.api.controle;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.enquete.api.dto.QuestionarioUsuarioDTO;
import br.com.enquete.api.dto.RespostaQuestionarioDTO2;
import br.com.enquete.dominio.servico.QuestionarioUsuarioService;
import br.com.enquete.dominio.servico.RespostaQuestionarioService;

@RestController
@RequestMapping(value = "/questionario-usuario", path = "/questionario-usuario")
public class QuestionarioUsuarioController extends BaseController2<QuestionarioUsuarioDTO> {
  QuestionarioUsuarioService service;  

  @Autowired
  public QuestionarioUsuarioController(QuestionarioUsuarioService service, RespostaQuestionarioService serviceRespostaQuestionario) {
    super(service);
    this.service = service;
  } 
  
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<QuestionarioUsuarioDTO> gravar(@RequestBody QuestionarioUsuarioDTO entidade) {
    QuestionarioUsuarioDTO d = service.gravar(entidade);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigoQuestionarioUsuario}")
              .buildAndExpand(d.getCodigoQuestionarioUsuario()).toUri();
      return ResponseEntity.created(uri).body(d);
  }
  
  @PostMapping(path="/insere-questionario",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RespostaQuestionarioDTO2> insereQuestionario(@RequestBody RespostaQuestionarioDTO2 objeto) {    
    
    return new ResponseEntity<>(service.insereQuestionario(objeto), HttpStatus.OK);
  }
}
