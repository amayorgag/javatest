package calculator;

import java.math.BigDecimal;

/**
 * Created by amayorga on 16/04/16.
 */
public class SubtractionOperator extends Operator {

    public SubtractionOperator() {
        this.precedence = 1;
        this.symbol = MINUS;
    }

    @Override
    public BigDecimal apply(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.subtract(rightOperand);
    }
}
