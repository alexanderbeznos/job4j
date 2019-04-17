package ru.job4j.loop;

/**
 * Вычисление факториала.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 17.04.2019.
 */
public class Factorial {
    /**
     * Подсчёт факторила.
     * @param n акториал.
     * @return result.
     */
    public int calc(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;

            }
        return result;
    }
}
