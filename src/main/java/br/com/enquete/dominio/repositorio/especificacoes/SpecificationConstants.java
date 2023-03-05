package br.com.enquete.dominio.repositorio.especificacoes;


public class SpecificationConstants {
    private SpecificationConstants() {
    }

    public static final String BLANK = "";
    public static final String JOIN_AND = "AND";
    public static final String JOIN_OR = "OR";
    public static final String OPERATOR_EQUAL = "EQ";
    public static final String OPERATOR_NOTEQUAL = "NE";
    public static final String OPERATOR_CONTAIN = "CT";
    public static final String OPERATOR_NOT_CONTAIN = "NC";
    public static final String OPERATOR_START_WITH = "SW";
    public static final String OPERATOR_ENDS_WITH = "EW";
    public static final String OPERATOR_GREATER_THAN = "GT";
    public static final String OPERATOR_LESS_THAN = "LT";
    public static final String OPERATOR_GREATER_THAN_EQUAL = "GE";
    public static final String OPERATOR_LESS_THAN_EQUAL = "LE";
    public static final String OPERATOR_IN = "IN";
    public static final String DATA_PERCENT_SYMBOL = "%";
    public static final String BOOLEAN = "boolean";
    public static final String BYTE = "byte";
    public static final String CHARACTER = "character";
    public static final String SHORT = "short";
    public static final String INTEGER = "integer";
    public static final String LONG = "long";
    public static final String FLOAT = "float";
    public static final String DOUBLE = "double";
    public static final String BIGINTEGER = "biginteger";
    public static final String BIGDECIMAL = "bigdecimal";
    public static final String CPF_CNPJ = "cpf_cnpf";
    public static final String DATE = "date";
    public static final String REGEX_DATE_TIME= "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}.\\d{3}Z";
    public static final String REGEX_ONLY_WORDS= "(?![a-zA-Z0-9À-ž])+\\W";
}
