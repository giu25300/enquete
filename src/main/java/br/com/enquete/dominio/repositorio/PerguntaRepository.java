package br.com.enquete.dominio.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.enquete.dominio.entidade.Pergunta;

@Repository
public interface PerguntaRepository extends BaseRepository<Pergunta,Integer>{

  /**
   * @return Todas as perguntas cadastradas na tabela
   * ordernadas pela chave sequencial
   */
  @Transactional(readOnly = true)
  @Query(value="select p from Pergunta p "+
      "order by p.codigoPergunta")
  List<Pergunta> listar();


  /**
   * @param codigoPergunta
   * @return Todas as subperguntas cadastradas para a pergunta
   * ordernadas pela chave sequencial
   */
  @Transactional(readOnly = true)
  @Query(value="select p from Pergunta p"+
      " where p.perguntaPai.codigoPergunta=:codigoPergunta " +
      " order by p.codigoPergunta")
  List<Pergunta> listarPorPergunta(@Param("codigoPergunta") Integer codigoPergunta);

  List<Pergunta> findByDescricaoPergunta(@Param("descricaoPergunta") String descricaoPergunta);
}