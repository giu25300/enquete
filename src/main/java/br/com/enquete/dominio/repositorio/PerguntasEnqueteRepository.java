package br.com.enquete.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.enquete.dominio.entidade.PerguntasEnquete;

@Repository
public interface PerguntasEnqueteRepository extends BaseRepository<PerguntasEnquete,Integer>{
  
    @Query(value="select q from PerguntasEnquete q "+
      " join q.pergunta perg " +      
      " where q.enquete.codigoEnquete=:codigoEnquete")
  List<PerguntasEnquete> listarPerguntas(@Param("codigoEnquete") Integer codigoEnquete);
}