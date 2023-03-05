package br.com.enquete.dominio.servico;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.enquete.api.dto.EnqueteDTO;
import br.com.enquete.dominio.entidade.Enquete;
import br.com.enquete.dominio.repositorio.EnqueteRepository;
import lombok.extern.slf4j.Slf4j;

/**
 * @author mex9856
 * @name Giuliano Rosa da Silva
 */

@Slf4j
@Service
public class EnqueteService extends BaseService2<EnqueteDTO, Enquete> {
  private EnqueteRepository repository;
  
  public EnqueteService(EnqueteRepository repository) {
    super(repository, EnqueteDTO.class, Enquete.class); 
    this.repository = repository;
  }

  public EnqueteRepository getRepository() {
    return repository;
  }

  public void setRepository(EnqueteRepository repository) {
    this.repository = repository;
  }
  
  public List<Enquete> findByDescricaoEnquete(String descricaoEnquete) {
    return repository.findByDescricaoEnquete(descricaoEnquete);
  }
}