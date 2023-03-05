package br.com.enquete.dominio.repositorio.especificacoes;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

public class Specifications{

    public static <T> Specification<T> whereId(Long id) {
        return (root, cq, builder)
                -> builder.equal(root.get("id"), id);
    }

    public static   <T> Specification<T> whereId(String campo, Long idUnidade){
        return (root, cq, builder)
                -> builder.equal(root.get("campo").get("id"),idUnidade) ;
    }

    public static <T> Specification<T> columnsLike(String text) {
        if (!text.contains("%")) {
            text = "%" + text + "%";
        }
        final String finalText = text.toUpperCase();

        return (root, cq, builder) ->
                builder.or(root.getModel()
                        .getDeclaredSingularAttributes()
                        .stream()
                        .filter(a -> a.getJavaType()
                                .getSimpleName().equalsIgnoreCase("string"))
                        .map(a -> builder.like(builder.upper(root.get(a.getName())), finalText)
                        ).toArray(Predicate[]::new));
    }
}
