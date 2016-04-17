package calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by amayorga on 16/04/16.
 */
public class Tokenizer {

    public List<Token> tokenize(List<String> iputs) {
        return iputs.stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }

    public Token parse(String input) {
        Token result = null;

        if (Operator.isOperator(input)) {
            result = Token.operatorToken(Operator.getOperator(input));
        } else {
            result = Token.valueToken(parseValue(input));
        }

        return result;
    }

    private BigDecimal parseValue(String input) {
        ensureValidToken(input);

        String striped = input.replaceAll(",", "");
        striped = striped.replaceAll("\\s+", "");
        return new BigDecimal(striped);
    }

    private void ensureValidToken(String input) {
        if (input.length() == 0) {
            throw new RuntimeException("Invalid numeric input with lengh of zero");
        }
        if (input.charAt(0) == ',') {
            throw new RuntimeException("Numeric Input cant start with comma: " + input);
        }

        String[] parts = input.split("\\.");

        //System.out.println("separating by dot input " + input+ ": " + Arrays.asList(parts));
        if (parts.length < 1) return;

        String thousands = parts[0];

        List<String> thousandParts = Arrays.asList(thousands.split(","));

        if (thousandParts.size() >= 2) {
            // System.out.println(thousandParts.subList(1, thousandParts.size()));
            thousandParts.subList(1, thousandParts.size())
                    .stream()
                    .filter(e -> e.length() != 3)
                    .findFirst()
                    .ifPresent(s -> {
                        throw new RuntimeException("Invalid Numeric Input, thousands are not well formatted: " + input);
                    });
        }
    }

}
