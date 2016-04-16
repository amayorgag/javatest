package calculator;

import java.math.BigDecimal;

/**
 * Created by amayorga on 16/04/16.
 */
public class MultiplicationOperator extends Operator {

    public MultiplicationOperator() {
        this.precedence = 3;
        this.symbol = MUL;
    }

    @Override
    public BigDecimal apply(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.multiply(rightOperand);
    }
}
