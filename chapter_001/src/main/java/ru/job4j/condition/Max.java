package ru.job4j.condition;

/**
 * Максимум из двух чисел.
 *
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 14.04.2019.
 */

public class Max {
    /**
     * Max from first and second.
     *
     * @param left  первое значение.
     * @param right второе значение.
     *              return result ответ.
     */
    public int max(int left, int right) {
        int result = left > right ? left : right;
        return result;
    }
}