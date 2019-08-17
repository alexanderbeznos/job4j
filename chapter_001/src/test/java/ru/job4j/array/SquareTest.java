package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 26.04.2019.
 */

public class SquareTest {
    /**
     * Test "массив в квадарт числа 1,2,3".
     */
    @Test
    public void wherBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }
    /**
     * Test "массив в квадарт числа 1,2,3,4,5".
     */
    @Test
    public void wherBound3Then1491625() {
        int bound = 5;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25};
        assertThat(rst, is(expect));
    }
    /**
     * Test "массив в квадарт числа 1,2,3,4,5,6,7,8,9,10".
     */
    @Test
       public void wherBound3Then14916253642496481100() {
        int bound = 10;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
        assertThat(rst, is(expect));
    }
}
