package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * since 09.05.2019;
 */
public class PointTest {
    /**
     * Test from coordinate to distance 0,0,0,10.
     */
    @Test
    public void whenZeroAndTenThenTen() {
        Point first = new Point(0, 0);
        Point second = new Point(0, 10);
        double result = first.distance(second);
        first.info();
        second.info();
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(10d));
    }
    /**
     * Test from coordinate to distance 0,0.
     */
    @Test
    public void whenCheckItself() {
        Point point = new Point(0, 0);
        double result = point.distance(point);
        assertThat(result, is(0D));
    }
    /**
     * Test from coordinate to distance 1,1,2,2.
     */
    @Test
    public void whenShowInfo() {
        Point first = new Point(1, 1);
        first.info();
        Point second = new Point(2, 2);
        second.info();
    }
    /**
     * Test from coordinate to distance 1,0,4,0,8,0.
     */
    @Test
    public void whenZeroAnd3() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(1, 4, 8);
        double result = first.distance3d(second);
        System.out.println(String.format("Result is %s", result));
        assertThat(result, is(9d));
    }
}

