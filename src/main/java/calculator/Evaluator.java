package calculator;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
        BigDecimal result = evaluatePostfixExpression(toPostfixExpression(tokens));

        return result;
    }

    private BigDecimal evaluatePostfixExpression(List<Token> tokens) {
        return null;
    }

    private List<Token> toPostfixExpression(List<Token> tokens) {
        List<Token> postfix = new InfixToPostfixConverter(tokens).convert();
        System.out.println("Postfix Sequence is: " + postfix);
        return postfix;
    }

    private class InfixToPostfixConverter {

        private final List<Token> infixExpression;
        private List<Token> result;
        private Stack<Token> opStack;


        public InfixToPostfixConverter(List<Token> infixExpression) {
            this.infixExpression = infixExpression;
            this.result = new LinkedList<>();
            this.opStack = new Stack<>();
        }

        public List<Token> convert() {
            for (int i = 0; i < infixExpression.size(); i++) {
                if (hasUnexpectedTokenAt(i)) {
                    throw new RuntimeException("Sequence is an invalid arithmetic infix expression: "
                            + infixExpression);
                }
                proccessTokenAt(i);
            }

            while (!opStack.isEmpty()) {
                result.add(opStack.pop());
            }

            return result;
        }

        private void proccessTokenAt(int i) {
            Token token = infixExpression.get(i);
            if (token.isValue()) {
                result.add(token);
            } else {
                proccessOperator(token);
            }
        }

        private void proccessOperator(Token token) {
            if (opStack.isEmpty()) {
                opStack.push(token);
            } else if (opStack.peek().getOperator().getPrecedence() < token.getOperator().getPrecedence()) {
                opStack.push(token);
            } else {
                repositionPreviousOperators(token);
            }
        }

        private void repositionPreviousOperators(Token token) {
            while (!opStack.isEmpty()
                    && opStack.peek().getOperator().getPrecedence() >= token.getOperator().getPrecedence()) {
                result.add(opStack.pop());
            }
            opStack.push(token);
        }

        private boolean hasUnexpectedTokenAt(int i) {
            return i % 2 == 0 && infixExpression.get(i).isOperator();
        }

    }

}
