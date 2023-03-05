package br.com.enquete.dominio.repositorio;

import org.springframework.stereotype.Repository;

import br.com.enquete.dominio.entidade.RespostaQuestionario;

@Repository
public interface RespostaQuestionarioRepository extends BaseRepository<RespostaQuestionario,Integer>{ 
}