package br.com.enquete.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.enquete.api.dto.RespostaQuestionarioDTO;
import br.com.enquete.dominio.repositorio.especificacoes.Filtro;
import br.com.enquete.dominio.servico.RespostaQuestionarioService;

@RestController
@RequestMapping(value = "/resposta-questionario", path = "/resposta-questionario")
public class RespostaQuestionarioController<RespostaQuestionario> extends BaseController2<RespostaQuestionarioDTO> {

  RespostaQuestionarioService service;

  @Autowired
  public RespostaQuestionarioController(RespostaQuestionarioService service) {
    super(service);
    this.service = service;
  }

  @GetMapping(path = "listar-resposta-questionario")
  public Page<RespostaQuestionarioDTO> listarQuestionario(@RequestBody List<Filtro> filtros, Pageable pageable) {
    return null;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> gravar(@RequestBody RespostaQuestionarioDTO entidade) {
    return new ResponseEntity<>(service.gravar(entidade), HttpStatus.OK);
  }
}