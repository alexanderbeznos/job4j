package ru.job4j.condition;

/**
 * Максимум из трёх чисел.
 *
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 14.04.2019.
 */

public class MultiMax {
    /**
     * Max from first,second,third.
     *
     * @param first  первое значение.
     * @param second второе значение.
     * @param third третье значение.
     * return result ответ.
     */
    public int max(int first, int second, int third) {
        int result = first;
        result = first > second ? first : second;
        result = result > third ? first : third;
        return result;
    }
}
