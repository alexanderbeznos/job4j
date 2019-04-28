package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Aдexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 28.04.2019.
 */
public class BubbleSortTest {
    /**
     * Test "1, 5, 4, 2, 3, 1, 7, 8, 0, 5".
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort check = new BubbleSort();
        int[] input = new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] result = check.pooz(input);
        int[] expect = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(result, is(expect));
     }
}