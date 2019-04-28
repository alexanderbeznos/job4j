package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 28.04.2019.
 */

public class FindLoopTest {
    /**
     * Test "нахождение числа 5".
     */
    @Test
    public void whenArrayHas5Then0() {
        FindLoop find = new FindLoop();
        int[] input = {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
    /**
     * Test "нахождение числа 8".
     */
    @Test
    public void whenArrayHas5Then3() {
        FindLoop find = new FindLoop();
        int[] input = {7, 17, 8, 14, 5};
        int value = 8;
        int result = find.indexOf(input, value);
        int expect = 2;
        assertThat(result, is(expect));
    }
    /**
     * Test "нахождение числа 27".
     */
    @Test
    public void whenArrayHas5Then7() {
        FindLoop find = new FindLoop();
        int result = find.indexOf(new int[] {5, 10, 3, 41, 27, 92, 2}, 27);
        int expect = 4;
        assertThat(result, is(expect));
    }
    @Test
    public void whenArrayHas5Thenno() {
        FindLoop find = new FindLoop();
        int result = find.indexOf(new int[] {5, 10, 3, 41, 27, 92, 2}, 11);
        int expect = -1;
        assertThat(result, is(expect));
    }
}

