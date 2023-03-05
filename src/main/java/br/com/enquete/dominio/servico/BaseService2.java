package br.com.enquete.dominio.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import br.com.enquete.api.dto.BaseDTO;
import br.com.enquete.dominio.repositorio.BaseRepository;
import br.com.enquete.dominio.repositorio.especificacoes.Filtro;
import br.com.enquete.dominio.repositorio.especificacoes.SpecificationUtils;
import br.com.enquete.dominio.repositorio.especificacoes.Specifications;

public class BaseService2<D, T> implements IBaseService<D, T> {

  @Autowired
  EntityManager entityManager;

  private final BaseRepository<T, Integer> repository;
  private final Class<D> dtoClass;
  private final Class<T> entityClass;

  public BaseService2(BaseRepository<T, Integer> repository, Class<D> dtoClass, Class<T> entityClass) {
    this.repository = repository;
    this.dtoClass = dtoClass;
    this.entityClass = entityClass;
  }

  @Transactional(rollbackFor = Throwable.class)
  public D gravar(D d) {

    T t = mapFromDTO(d, entityClass);
    return mapToDTO(repository.save(t), dtoClass);
  }

  @Transactional(rollbackFor = Throwable.class)
  public T gravarEntidade(T t) {

    return repository.save(t);
  }

  @Transactional(rollbackFor = Throwable.class)
  public List<D> gravarTodos(List<D> list) {
    return mapAllToDTO(repository.saveAll(mapAllToEntity(list, entityClass)), dtoClass);
  }

  public D buscarPeloId(Integer id) {
    T t = repository.findById(id).orElseThrow(this::notFound);
    return mapToDTO(t, dtoClass);
  }

  public T buscarEntitidadePeloId(Integer id) {
    return repository.findById(id).orElseThrow(this::notFound);
  }

  @Transactional(rollbackFor = Throwable.class)
  public D atualizar(D dto, Integer id) {
    T saved = repository.findById(id).orElseThrow(this::notFound);

    T t = mapFromDTO(dto, entityClass);
    modelMapper().map(t, saved);
    return mapToDTO(repository.save(saved), dtoClass);
  }

  @Transactional(rollbackFor = Throwable.class)
  public void apagarPorId(Integer id) {
    repository.deleteById(id);
  }

  public List<D> listar() {
    return mapAllToDTO(repository.findAll(), dtoClass);
  }

  @Transactional
  public Page<D> paginado(Pageable pageable, String searchTerm) {
    Page<D> teste = repository.findAll(Specifications.columnsLike(searchTerm), pageable).map(entity -> mapToDTO(entity, dtoClass));
    return repository.findAll(Specifications.columnsLike(searchTerm), pageable).map(entity -> mapToDTO(entity, dtoClass));
  }

  public List<D> listarComFiltro(List<Filtro> filtros) {
    Specification<T> specification = SpecificationUtils.buildSpecification(filtros, new ArrayList<>());
    return mapAllToDTO(repository.findAll(specification), dtoClass);
  }

  public Page<?> paginadoComFiltro(List<Filtro> filtros, Pageable pageable, Class<? extends BaseDTO> aClass) {
    Specification<T> specification = SpecificationUtils.buildSpecification(filtros, new ArrayList<>());
    return repository.findAll(specification, pageable).map(entity -> modelMapper().map(entity, aClass));

  }

  public Class<D> getDTOClass() {
    return this.dtoClass;
  }

  public Class<T> getEntityClass() {
    return this.entityClass;
  }

  public NoSuchElementException notFound() {
    return notFound(String.format("%s não localizado(a).", getEntityClass().getSimpleName().split("(?=\\p{Upper})")[0]));
  }

  public NoSuchElementException notFound(String msg) {
    return new NoSuchElementException(msg);
  }

  public void validarSeNUll(Object o, String msgErr) {
    if (Objects.isNull(o))
      notFound(msgErr);
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }
}
