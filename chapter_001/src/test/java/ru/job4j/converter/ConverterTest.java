package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 13.04.2019.
 */

public class ConverterTest {
    /**
     * Test dol to rub.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToDollar(60);
        assertThat(result, is(1));
    }
    /**
     * Test rub to euro.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter converter = new Converter();
        int result = converter.rubleToEuro(70);
        assertThat(result, is(1));
    }
    /**
     * Test euro to rub.
     */
    @Test
    public void when8EuroToRubleThen560() {
        Converter converter = new Converter();
        int result = converter.euroToRuble(8);
        assertThat(result, is(560));
    }
    /**
     * Test dol to rub..
     */
    @Test
    public void when11DollarToRubleThen660() {
        Converter converter = new Converter();
        int result = converter.dollarToRuble(11);
        assertThat(result, is(660));
    }
}
