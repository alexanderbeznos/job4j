package ru.job4j.calculator;
import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Alexander Beznos (ast1bn@mail.ru).,.m
 * @version 1.0
 * @since 13.04.2019.
 */
public class FitTest {
    /**
     * Test best weight for man
     */
    @Test
    public void  manWeight() {
        Fit fit = new Fit();
        double weight = fit.manWeight(180);
        assertThat(weight, closeTo(92.0, 0.1));
    }
    /**
     * Test best weight for woman
     */
    @Test
    public void womanWeight() {
        Fit fit = new Fit();
        double weight = fit.womanWeight(170);
        assertThat(weight, closeTo(69.0, 0.1));
    }
}
