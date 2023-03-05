package br.com.enquete.api.controle;

import java.net.URI;
import java.util.List;

import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.enquete.api.dto.PerguntasEnqueteDTO;
import br.com.enquete.dominio.servico.PerguntaEnqueteService;


@RestController
@RequestMapping(value = "/pergunta-enquete", path = "/pergunta-enquete")
public class PerguntasEnqueteController<PerguntasEnquete> extends BaseController2<PerguntasEnqueteDTO> {
  private final PerguntaEnqueteService service;

  @Autowired
  public PerguntasEnqueteController(PerguntaEnqueteService service) {
    super(service);
    this.service = service;
  }

  @GetMapping(path = "/listar-perguntas-enquete", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> listarQuestionario(@RequestParam(name="codigoEnquete", required=true) @Positive Integer codigoEnquete) {
    List<PerguntasEnqueteDTO> resultado = service.listarPerguntas(codigoEnquete);

    return new ResponseEntity<>(resultado, resultado.isEmpty()? HttpStatus.NO_CONTENT : HttpStatus.OK);
  }

  @PostMapping(path="/inserir",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PerguntasEnqueteDTO> gravar(@RequestBody PerguntasEnqueteDTO entidade) {
    PerguntasEnqueteDTO d = service.gravar(entidade);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigoPerguntaEnquete}")
              .buildAndExpand(d.getCodigoPerguntaEnquete()).toUri();
      return ResponseEntity.created(uri).body(d);
  }
}