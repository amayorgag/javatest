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

    @Test
    public void whenListHasOneValueReturnsValue() {
        Assert.assertEquals(new BigDecimal(11), evaluator.evaluate(Arrays.asList("11")));
    }

    @Test(expected = RuntimeException.class)
    public void whenNumberOfElementsIsEvenThrows() {
        List<String> evenList = Arrays.asList("","");
        evaluator.evaluate(evenList);
    }

    @Test(expected = RuntimeException.class)
    public void whenThousandsCommaTakesTooMuchDigitsThrows() {
        evaluator.evaluate(Arrays.asList("10,0000"));
    }

    @Test(expected = RuntimeException.class)
    public void whenThousandsCommaDoesntTakeEnoughDigitsThrows() {
        evaluator.evaluate(Arrays.asList("100,02"));
    }

    @Test(expected = RuntimeException.class)
    public void whenInputStartsWithCommaThrows() {
        evaluator.evaluate(Arrays.asList(",302"));
    }

    @Test(expected = RuntimeException.class)
    public void whenListDoesNotHaveOperatorsThrows() {
        evaluator.evaluate(Arrays.asList("2", "1"));
    }

    @Test(expected = RuntimeException.class)
    public void whenListIsNotValidInfixExpressionThrows() {
        evaluator.evaluate(Arrays.asList("+", "2", "1"));
    }

    @Test
    public void whenInputsAreValidInfixExpressionReturnsEvaluation() {
        Assert.assertEquals(new BigDecimal(3), evaluator.evaluate(Arrays.asList("1", "+", "2")));
        Assert.assertEquals(new BigDecimal(2), evaluator.evaluate(Arrays.asList("4", "/", "2")));

        Assert.assertEquals(
                new BigDecimal(7),
                evaluator.evaluate(Arrays.asList("1", "+", "2", "*", "3")));


        BigDecimal smallResult =
                (new BigDecimal(1).divide(new BigDecimal(323), 2)).subtract(new BigDecimal(765));
        Assert.assertEquals(
                smallResult,
                evaluator.evaluate(Arrays.asList("1", "/", "323", "-", "765")));


        BigDecimal bigResult =
                new BigDecimal("10592.76")
                .add(new BigDecimal(780))
                .add(new BigDecimal(10000).multiply(new BigDecimal("200.76")));
        List<String> bigList =
                Arrays.asList("10,592.76", "+", "780", "+" ,"10000", "*", "200.76");
        Assert.assertEquals(bigResult, evaluator.evaluate(bigList));
    }

}