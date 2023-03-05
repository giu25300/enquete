package br.com.enquete.dominio.repositorio;

import org.springframework.stereotype.Repository;

import br.com.enquete.dominio.entidade.TipoPergunta;

@Repository
public interface TipoPerguntaRepository extends BaseRepository<TipoPergunta,Integer>{ 
}