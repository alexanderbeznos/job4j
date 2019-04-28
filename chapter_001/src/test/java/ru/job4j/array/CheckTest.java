package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 28.04.2019.
 */

public class CheckTest {
    /**
     * Test "true, true, true".
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test "true, false, true".
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Test "true, true, true, true".
     */
    @Test
    public void whenDataMonoByTrueThenTrue4() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Test "false, false, false, false".
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse4() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}