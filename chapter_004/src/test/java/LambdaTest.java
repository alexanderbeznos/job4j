import lambda.Lambda;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 22.08.2019.
 */
public class LambdaTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Lambda function = new Lambda();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        Lambda function = new Lambda();
        List<Double> result = function.diapason(5, 8, x -> Math.pow(x, 2) + 4 * x + 3);
        List<Double> expected = Arrays.asList(48D, 63D, 80D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Lambda function = new Lambda();
        List<Double> result = function.diapason(5, 8, x -> Math.log10(x) + 1);
        List<Double> expected = Arrays.asList(Math.log10(5) + 1, Math.log10(6) + 1,Math.log10(7) + 1);
        assertThat(result, is(expected));
    }
}
