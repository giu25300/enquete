package br.com.enquete.dominio.repositorio.especificacoes;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import lombok.Getter;
import lombok.Setter;

public class SpecificationUtils {

  private SpecificationUtils() {
  }

  public static <T> Specification<T> buildSpecification(List<Filtro> filtros,
      List<Expression<? extends Comparable<?>>> externalExpressionList) {
    List<Expression<? extends Comparable<?>>> expressionList = new ArrayList<>();
    if (null != externalExpressionList) {
      expressionList.addAll(externalExpressionList);
    }
    expressionList.addAll(parseFromObject(filtros));
    return new CustomSpecification<>(expressionList);
  }

  @Getter
  @Setter
  public static class CustomSpecification<T> implements Specification<T> {

    private List<Expression<? extends Comparable<?>>> expressions;

    public CustomSpecification(
        List<Expression<? extends Comparable<?>>> expressions) {
      super();
      this.expressions = expressions;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
        CriteriaBuilder cb) {
      Predicate result = cb.conjunction();
      for (Expression<? extends Comparable<?>> expression : expressions) {
        if (null != expression && null != expression.getField()
            && null != expression.getOperator()
            && (null != expression.getValue()
                || null != expression.getValues())) {
          Predicate tmpPredicate = handleExpression(root, cb, expression);
          if (SpecificationConstants.JOIN_AND
              .equalsIgnoreCase(expression.getJoin())) {
            result = cb.and(result, tmpPredicate);
          } else if (SpecificationConstants.JOIN_OR
              .equalsIgnoreCase(expression.getJoin())) {
            result = cb.or(result, tmpPredicate);
          }
        }
      }
      return result;
    }
  }

  private static Path getPath(Root<?> root, String attributeName) {
    Path<?> path = root;
    for (String part : attributeName.split("\\.")) {
      path = path.get(part);
    }
    return path;
  }

  private static <T, E extends Comparable<E>> Predicate handleExpression(
      Root<T> root, CriteriaBuilder cb, Expression<E> expression) {
    Predicate tempPredicate = null;
    Path path = getPath(root, expression.getField());
    switch (expression.getOperator()) {
      case SpecificationConstants.OPERATOR_EQUAL :
        tempPredicate = cb.equal(path, expression.getValue());
        break;
      case SpecificationConstants.OPERATOR_NOTEQUAL :
        tempPredicate = cb.notEqual(getPath(root, expression.getField()),
            expression.getValue());
        break;
      case SpecificationConstants.OPERATOR_CONTAIN :
        tempPredicate = cb.like(path,
            SpecificationConstants.DATA_PERCENT_SYMBOL + expression.getValue()
                + SpecificationConstants.DATA_PERCENT_SYMBOL);
        break;
      case SpecificationConstants.OPERATOR_NOT_CONTAIN :
        tempPredicate = cb.notLike(path,
            SpecificationConstants.DATA_PERCENT_SYMBOL + expression.getValue()
                + SpecificationConstants.DATA_PERCENT_SYMBOL);
        break;
      case SpecificationConstants.OPERATOR_START_WITH :
        tempPredicate = cb.like(path,
            expression.getValue() + SpecificationConstants.DATA_PERCENT_SYMBOL);
        break;
      case SpecificationConstants.OPERATOR_ENDS_WITH :
        tempPredicate = cb.like(path,
            SpecificationConstants.DATA_PERCENT_SYMBOL + expression.getValue());
        break;
      case SpecificationConstants.OPERATOR_GREATER_THAN :
        tempPredicate = cb.greaterThan(path, expression.getValue());
        break;
      case SpecificationConstants.OPERATOR_LESS_THAN :
        tempPredicate = cb.lessThan(path, expression.getValue());
        break;
      case SpecificationConstants.OPERATOR_GREATER_THAN_EQUAL :
        tempPredicate = cb.greaterThanOrEqualTo(path, expression.getValue());
        break;
      case SpecificationConstants.OPERATOR_LESS_THAN_EQUAL :
        tempPredicate = cb.lessThanOrEqualTo(path, expression.getValue());
        break;
      case SpecificationConstants.OPERATOR_IN :
        tempPredicate = path.in(expression.getValues());
        break;
      default :
        // Do nothing - Not required as per business logic but SonarLint gives
        // log
    }
    return tempPredicate;
  }

  private static List<Expression<? extends Comparable<?>>> parseFromObject(
      List<Filtro> filtros) {
    List<Expression<? extends Comparable<?>>> retVal = new ArrayList<>();
    for (Filtro f : filtros) {
      String type = f.getType();
      if (type.equalsIgnoreCase(SpecificationConstants.BOOLEAN)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            Boolean.parseBoolean(String.valueOf(f.getValue())), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.BYTE)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            Byte.valueOf(String.valueOf(f.getValue())), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.CHARACTER)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            String.valueOf(f.getValue()).charAt(0), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.SHORT)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            Short.valueOf(String.valueOf(f.getValue())), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.INTEGER)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            Integer.valueOf(String.valueOf(f.getValue())), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.LONG)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            Long.valueOf(String.valueOf(f.getValue())), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.FLOAT)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            Float.valueOf(String.valueOf(f.getValue())), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.DOUBLE)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            Double.valueOf(String.valueOf(f.getValue())), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.BIGINTEGER)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            BigInteger.valueOf((Long) f.getValue()), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.BIGDECIMAL)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            BigDecimal.valueOf((Long) f.getValue()), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.DATE)) {
        String str = String.valueOf(f.getValue()).split("T")[0]
            .concat(" 00:00:00");
        DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss");
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            LocalDateTime.parse(str, formatter), null));
      } else if (type.equalsIgnoreCase(SpecificationConstants.CPF_CNPJ)) {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            String.valueOf(f.getValue()).replaceAll(
                SpecificationConstants.REGEX_ONLY_WORDS, ""),
            null));
      } else {
        retVal.add(new Expression<>(f.getField(), f.getOperator(), f.getJoin(),
            String.valueOf(f.getValue()), null));

      }
    }
    return retVal;
  }

  @Getter
  @Setter
  public static class Expression<E extends Comparable<E>>
      implements
        Serializable {
    private String field;
    private String operator;
    private String join;
    private transient E value;
    private transient List<E> values;

    public Expression(String field, String operator, String join, E value,
        List<E> values) {
      super();
      this.field = field;
      this.operator = operator;
      this.join = join;
      this.value = value;
      this.values = values;
    }

  }
}
