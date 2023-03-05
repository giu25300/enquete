package br.com.enquete.dominio.repositorio;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @param <T>  Classe de Persistência
 * @param <PK> Tipo de Chave Primária UUID, int, String...
 */
@NoRepositoryBean
public interface BaseRepository<T, PK extends Serializable> extends JpaRepository<T, PK> , JpaSpecificationExecutor<T> {

  Page<T> findAll(Specification<T> spec, Pageable pageable);

}