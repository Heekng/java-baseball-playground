package step2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum Operator {

    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (second == 0) {
            throw new IllegalArgumentException();
        }
        return first / second;
    }),
    ;

    private String symbol;
    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    private static final Map<String, Operator> OPERATOR_MAP = Collections.unmodifiableMap(
        Arrays.stream(values()).collect(Collectors.toMap(Operator::getSymbol, operator -> operator)));

    private String getSymbol() {
        return symbol;
    }

    public int operate(int first, int second) {
        return operation.apply(first, second);
    }

    public static Operator findOperator(String symbol) {
        Operator operator = OPERATOR_MAP.get(symbol);
        if (operator == null) {
            throw new IllegalArgumentException();
        }
        return operator;
    }
}
