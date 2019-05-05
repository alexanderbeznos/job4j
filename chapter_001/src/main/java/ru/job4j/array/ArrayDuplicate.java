package ru.job4j.array;

import java.util.Arrays;
/**
 * Удаление дубликатов в массиве.
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 30.04.2019.
 */
public class ArrayDuplicate {
    /**
     *
     * @param array массив вводимый.
     * @return unique массив.
     */
    public String[] remove(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out +1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}
