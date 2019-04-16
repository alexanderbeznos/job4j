package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 17.04.2019.
 */

public class CounterTest {
    /**
     * Test сумма.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
     }
}