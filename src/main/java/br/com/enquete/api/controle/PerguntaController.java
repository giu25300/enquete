package br.com.enquete.api.controle;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.enquete.api.dto.PerguntaDTO;
import br.com.enquete.dominio.servico.PerguntaService;

@RestController
@RequestMapping(value = "/pergunta", path = "/pergunta")
public class PerguntaController<Pergunta> extends BaseController2<PerguntaDTO> {	
  PerguntaService service;	
	
	@Autowired
	public PerguntaController(PerguntaService service) {
		super(service);
		this.service =  service;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<PerguntaDTO> gravar(@RequestBody PerguntaDTO entidade) {
	  PerguntaDTO d = service.gravar(entidade);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigoPergunta}")
              .buildAndExpand(d.getCodigoPergunta()).toUri();
      return ResponseEntity.created(uri).body(d);
  }
}