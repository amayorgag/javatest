package solvosoftjavatest;

import calculator.Evaluator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by amayorga on 16/04/16.
 */
@Service
public class CalculatorService {

    public BigDecimal calculate(List<String> tokens) {
        System.out.println("Calculate expression:" + tokens);
        return new Evaluator().evaluate(tokens);
    }
}
