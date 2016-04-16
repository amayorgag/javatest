package calculator;

import java.math.BigDecimal;

/**
 * Created by amayorga on 16/04/16.
 */
public class AdditionOperator extends Operator {

    public AdditionOperator() {
        this.precedence = 1;
        this.symbol = PLUS;
    }

    @Override
    public BigDecimal apply(BigDecimal leftOperand, BigDecimal rightOperand) {
        return leftOperand.add(rightOperand);
    }
}
