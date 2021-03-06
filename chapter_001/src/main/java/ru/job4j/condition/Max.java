package ru.job4j.condition;

/**
 * Максимум из двух чисел.
 *
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 14.04.2019.
 */

public class Max {
    /**
     * Max from first and second.
     *
     * @param left  первое значение.
     * @param right второе значение.
     * return result ответ.
     */
    public int max(int left, int right) {
        return left > right ? left : right;
    }
    public int max(int first, int second, int third) {
        int tmp = max(second, third);
        return max(first, tmp);
    }
    public int max(int first, int second, int third, int fourth) {
        int tmp = max(second, third, fourth);
        return max(first, tmp);
    }
}