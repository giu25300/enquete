package br.com.enquete.api.controle;
//package br.com.saneago.enquete.api.controle;
//
//import java.net.URI;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import br.com.saneago.enquete.api.dto.PerguntaDetalheDTO;
//import br.com.saneago.enquete.dominio.servico.SPerguntaDetalhe;
//
//
//@RestController
//@RequestMapping(value = "/pergunta-detalhe", path = "/pergunta-detalhe")
//public class PerguntaDetalheController<PerguntaDetalhe> extends BaseController2<PerguntaDetalheDTO> {
//
//  SPerguntaDetalhe service;
//
//  @Autowired
//  public PerguntaDetalheController(SPerguntaDetalhe service) {
//    super(service);
//    this.service = service;
//  }
//  
//  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//  public ResponseEntity<PerguntaDetalheDTO> gravar(@RequestBody PerguntaDetalheDTO entidade) {
//    PerguntaDetalheDTO d = service.gravar(entidade);
//      URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigoPerguntaDetalhe}")
//              .buildAndExpand(d.getCodigoPerguntaDetalhe()).toUri();
//      return ResponseEntity.created(uri).body(d);
//  }
//}