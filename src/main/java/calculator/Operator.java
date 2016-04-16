package calculator;

import java.math.BigDecimal;

/**
 * Created by amayorga on 16/04/16.
 */
public abstract class Operator {

    protected int precedence;
    protected String symbol;

    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String DIV = "/";
    static final String MUL = "*";

    public abstract BigDecimal apply(BigDecimal leftOperand, BigDecimal rightOperand);

    public static boolean isOperator(String s) {
        switch (s) {
            case PLUS:
            case MINUS:
            case DIV:
            case MUL:
                return true;
            default:
                return false;
        }
    }

    public static Operator getOperator(String s) {
        switch (s) {
            case PLUS:
                return new AdditionOperator();
            case MINUS:
                return new SubtractionOperator();
            case DIV:
                return new DivisionOperator();
            case MUL:
                return new MultiplicationOperator();
            default:
                throw new RuntimeException("Supplied string does not represents an arithmetic operand: "
                                           + s);
        }
    }

    public int getPrecedence() {
        return precedence;
    }

    @Override
    public String toString() {
        return getSymbol();
    }

    public String getSymbol() {
        return symbol;
    }
}
