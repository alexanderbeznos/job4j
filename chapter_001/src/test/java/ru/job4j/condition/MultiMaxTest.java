package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 14.04.2019.
 */

public class MultiMaxTest {
    /**
     * Test 1<2>3.
     */
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }
    /**
     * Test 2<1>3.
     */
    @Test
    public void whenFirstMax() {
        MultiMax check = new MultiMax();
        int result = check.max(8, 4, 6);
        assertThat(result, is(8));
    }
    /**
     * Test 1<3>2.
     */
    @Test
    public void whenThirdMax() {
        MultiMax check = new MultiMax();
        int result = check.max(3, 7, 8);
        assertThat(result, is(8));
    }
    /**
     * Test 1=2=3.
     */
    @Test
    public void whenAllMax() {
        MultiMax check = new MultiMax();
        int result = check.max(8, 8, 8);
        assertThat(result, is(8));
    }
}