package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 14.04.2019.
 */

public class MaxTest {
    /**
     * Test 1<2.
     */
    @Test
    public void whenMax1To2Then2() {
        Max max = new Max();
        int result = max.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Test 1>2.
     */
    @Test
    public void whenMax8To2Then1() {
        Max max = new Max();
        int result = max.max(8, 2);
        assertThat(result, is(8));
    }
    /**
     * Test 1=2.
     */
    @Test
    public void whenMax5To5Then12() {
        Max max = new Max();
        int result = max.max(5, 5);
        assertThat(result, is(5));
    }
}