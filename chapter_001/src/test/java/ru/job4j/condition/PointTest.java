package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * since 13.04.2019;
 */

public class PointTest {
    /**
     * Test from coordinate to distance
     */
    @Test
    public void whenZeroAndTenThenTen() {
        Point point = new Point();
        double result = point.distance(0, 0, 0, 10);
        assertThat(result, is(10d));
    }
}

