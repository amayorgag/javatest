package calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by amayorga on 16/04/16.
 */
public class Evaluator {

    public BigDecimal evaluate(List<String> inputs) {
        if (inputs.isEmpty()) {
            return BigDecimal.ZERO;
        }

        if (inputs.size() % 2 == 0) {
            throw new RuntimeException("Input list contains an invalid number of elements");
        }

        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize(inputs);
        BigDecimal result = evaluatePosfixExpression(toPostfixExpression(tokens));

        return result;
    }

    private BigDecimal evaluatePosfixExpression(List<Token> tokens) {
        return null;
    }

    private List<Token> toPostfixExpression(List<Token> tokens) {
        List<Token> result = new ArrayList<>();

        return result;
    }
}
