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

import br.com.enquete.api.dto.EnqueteDTO;
import br.com.enquete.dominio.servico.EnqueteService;

@RestController
@RequestMapping(value = "/enquete", path = "/enquete")
public class EnqueteController<Enquete> extends BaseController2<EnqueteDTO> {	
  EnqueteService service;	
	
	@Autowired
	public EnqueteController(EnqueteService service) {
		super(service);
		this.service =  service;
	}
	
	@PostMapping(path="/inserir", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<EnqueteDTO> gravar(@RequestBody EnqueteDTO entidade) {
	  EnqueteDTO d = service.gravar(entidade);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigoEnquete}")
              .buildAndExpand(d.getCodigoEnquete()).toUri();
      return ResponseEntity.created(uri).body(d);
  }
}