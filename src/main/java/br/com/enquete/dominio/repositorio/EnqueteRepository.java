package br.com.enquete.dominio.repositorio;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.enquete.dominio.entidade.Enquete;

@Repository
public interface EnqueteRepository extends BaseRepository<Enquete,Integer>{
  
  List<Enquete> findByDescricaoEnquete(@Param("descricaoEnquete") String descricaoEnquete);
}