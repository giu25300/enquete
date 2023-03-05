package br.com.enquete.api.controle;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.enquete.dominio.servico.BaseService2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseController2<D> {

    private final BaseService2<D, ?> service;

    protected BaseController2(BaseService2<D, ?> service) {
        this.service = service;
    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<D> gravar(@RequestBody D entidade) {
//        D d = service.gravar(entidade);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
//                .buildAndExpand(d.getId()).toUri();
//        return ResponseEntity.created(uri).body(d);
//    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<D> atualizar(@RequestBody D entidade, Integer id) {
        return ResponseEntity.ok(service.atualizar(entidade, id));
    }


    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)    
    public void apagarPorId(@PathVariable("id") Integer id) {
        service.apagarPorId(id);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)    
    public ResponseEntity<D> buscarPeloID(@PathVariable("id") Integer id) {

        Optional<D> optionalT = Optional.ofNullable(service.buscarPeloId(id));

        return optionalT.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping()    
    public Page<D> paginado(@RequestParam(value = "search", defaultValue = "", required = false) String search, Pageable pageable) {
        return service.paginado(pageable, search);
    }

    @GetMapping(path = "/listar/todos")    
    public List<D> listar() {
        return service.listar();
    }
}
