package calculator;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EvaluatorTest {

    Evaluator evaluator = new Evaluator();

    @Test
    public void whenEmptyListIsGivenReturnsZero() {
        Assert.assertEquals(BigDecimal.ZERO, evaluator.evaluate(Collections.emptyList()));
    }

    @Test(expected = RuntimeException.class)
    public void whenNumberOfElementsIsEvenThrows() {
        List<String> evenList = Arrays.asList("","");
        evaluator.evaluate(evenList);
    }

    @Test
    public void sumsTwoNumbers() {
        Assert.assertEquals(new BigDecimal(3), evaluator.evaluate(Arrays.asList("1", "+", "2")));
    }

}