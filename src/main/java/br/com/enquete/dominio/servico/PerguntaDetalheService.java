package br.com.enquete.dominio.servico;
//package br.com.saneago.enquete.dominio.servico;
//
//import org.springframework.stereotype.Service;
//
//import br.com.saneago.enquete.api.dto.PerguntaDetalheDTO;
//import br.com.saneago.enquete.dominio.entidade.PerguntaDetalhe;
//import br.com.saneago.enquete.dominio.repositorio.PerguntaDetalheRepository;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@Service
//public class SPerguntaDetalhe extends BaseService2<PerguntaDetalheDTO, PerguntaDetalhe> {
//  private PerguntaDetalheRepository repository;
//  
//  public SPerguntaDetalhe(PerguntaDetalheRepository repository) {
//    super(repository, PerguntaDetalheDTO.class, PerguntaDetalhe.class); 
//    this.repository = repository;
//  }
//
//  public PerguntaDetalheRepository getRepository() {
//    return repository;
//  }
//
//  public void setRepository(PerguntaDetalheRepository repository) {
//    this.repository = repository;
//  }
//  
////  public List<PerguntaDetalheDTO> listarPerguntaDetalhe(List<Filtro> filtros){    
////    return listarComFiltro(filtros, getDTOClass());
////  }
//}