package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;

/**
 * Test
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 30.04.2019.
 */

public class ArrayDuplicateTest {
    /**
     * Test "Привет", "Мир", "Привет", "Супер", "Мир".
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String [] input = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String [] except = {"Привет", "Мир", "Супер"};
        String [] result = duplicate.remove(input);
        assertThat(result, arrayContainingInAnyOrder(except));
    }
}