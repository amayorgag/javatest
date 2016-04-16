package calculator;

import java.math.BigDecimal;

/**
 * Created by amayorga on 16/04/16.
 */
public class DivisionOperator extends Operator {

    public DivisionOperator() {
        this.precedence = 3;
    }

    @Override
    public BigDecimal apply(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.divide(rightOperand);
    }
}
