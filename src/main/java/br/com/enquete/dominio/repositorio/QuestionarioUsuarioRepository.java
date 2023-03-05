package br.com.enquete.dominio.repositorio;

import org.springframework.stereotype.Repository;

import br.com.enquete.dominio.entidade.QuestionarioUsuario;

@Repository
public interface QuestionarioUsuarioRepository extends BaseRepository<QuestionarioUsuario,Integer>{ 
}