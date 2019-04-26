package ru.job4j.array;
/**
 * Вычисление массив в квадрат.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 26.04.2019.
 */
public class Square {
    /**
     * возведение в квадрат
     * @param bound число
     * @return числа в матрице в корне
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 0; i < bound; i++) {
            rst [i] = (int) (Math.pow(i + 1, 2));
        }
        return rst;
    }
}
