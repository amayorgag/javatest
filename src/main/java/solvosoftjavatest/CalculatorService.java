package solvosoftjavatest;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by amayorga on 16/04/16.
 */
@Service
public class CalculatorService {

    public BigDecimal calculate(List<String> tokens) {
        System.out.println("Calculate expresssion:" + tokens);



        return BigDecimal.ONE;
    }
}
