package calculator;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by amayorga on 16/04/16.
 */
public class Token {

    private Optional<BigDecimal> value;
    private Optional<Operator> operator;

    public static Token valueToken(BigDecimal value) {
        return new Token(value, null);
    }

    public static Token operatorToken(Operator operator) {
        return new Token(null, operator);
    }

    private Token(BigDecimal value, Operator operator) {
        this.value = Optional.ofNullable(value);
        this.operator = Optional.ofNullable(operator);
    }

    public boolean isOperator() {
        return operator.isPresent();
    }

    public BigDecimal getValue() {
        return value.get();
    }

    public Operator getOperator() {
        return operator.get();
    }

    public boolean isValue() {
        return value.isPresent();
    }

    @Override
    public String toString() {
        if (isOperator()) {
            return getOperator().toString();
        } else {
            return getValue().toString();
        }
    }
}
