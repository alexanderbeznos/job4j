package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
/**
 * Test
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 28.04.2019.
 */
public class TurnTest {
    /**
     * Test переворот массива 4,1,6,2.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[]{2, 6, 1, 4};
        assertThat(result, is(expect));
    }
    /**
     * Test переворот массива 4,1,6,2,8.
     */
    @Test
        public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[]{4, 1, 6, 2, 8};
        int[] result = turner.back(input);
        int[] expect = new int[]{8, 2, 6, 1, 4};
        assertThat(result, is(expect));
    }
}
