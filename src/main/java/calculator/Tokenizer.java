package calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by amayorga on 16/04/16.
 */
public class Tokenizer {

    public List<Token> tokenize(List<String> tokens) {
        return tokens.stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }

    public Token parse(String token) {
        Token result = null;

        if (Operator.isOperator(token)) {
            result = Token.operatorToken(Operator.getOperator(token));
        } else {
            result = Token.valueToken(parseValue(token));
        }

        return result;
    }

    private BigDecimal parseValue(String token) {
        String striped = token.replaceAll(",", "");
        striped = striped.replaceAll("\\s+", "");
        return new BigDecimal(striped);
    }
}
