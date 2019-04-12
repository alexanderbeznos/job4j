package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 12.04.2019
 */
public class CalculatorTest {
    /**
     * Test add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
            }
    /**
     * Test subtract.
     */
    @Test
    public void whenSubtractTwoMinusOneThenOne() {
        Calculator calc = new Calculator();
        double result = calc.subtract(2D, 1D);
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     * Test multiply.
     */
    @Test
    public void whenMultiplyTwoTimesThreeThenSix() {
        Calculator calc = new Calculator();
        double result = calc.multiply(2D, 3D);
        double expected = 6D;
        assertThat(result, is(expected));
    }
    /**
     * Test div.
     */
    @Test
        public void whenDivSixDivideThreeThenTwo() {
        Calculator calc = new Calculator();
        double result = calc.div(6D, 3D);
        double expected = 2D;
        assertThat(result, is(expected));
    }
}
