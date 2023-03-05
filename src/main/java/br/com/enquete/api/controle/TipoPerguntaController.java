package br.com.enquete.api.controle;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.enquete.api.dto.TipoPerguntaDTO;
import br.com.enquete.dominio.servico.TipoPerguntaService;


@RestController
@RequestMapping(value = "/tipo-pergunta", path = "/tipo-pergunta")
public class TipoPerguntaController<TipoPergunta> extends BaseController2<TipoPerguntaDTO> {

  private TipoPerguntaService service;

  @Autowired
  public TipoPerguntaController(TipoPerguntaService service) {
    super(service);
    this.service = service;
  }
  
  @Override
  @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)    
  public void apagarPorId(@PathVariable("APPLICATION_JSON_VALUE") Integer APPLICATION_JSON_VALUE) {
      service.apagarPorId(APPLICATION_JSON_VALUE);
  }
 
  @Override  
  @GetMapping(path = "/{codigoTipoPergunta}", produces = MediaType.APPLICATION_JSON_VALUE)    
  public ResponseEntity<TipoPerguntaDTO> buscarPeloID(@PathVariable("codigoTipoPergunta") Integer codigoTipoPergunta) {

      Optional<TipoPerguntaDTO> optionalT = Optional.ofNullable(service.buscarPeloId(codigoTipoPergunta));

      return optionalT.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<TipoPerguntaDTO> gravar(@RequestBody TipoPerguntaDTO entidade) {
    TipoPerguntaDTO d = service.gravar(entidade);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigoTipoPergunta}")
              .buildAndExpand(d.getCodigoTipoPergunta()).toUri();
      return ResponseEntity.created(uri).body(d);
  }
}