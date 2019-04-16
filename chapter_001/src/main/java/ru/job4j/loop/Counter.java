package ru.job4j.loop;

/**
 * Сумма чётных чисел.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 17.04.2019.
 */
public class Counter {
    /**
     * Сложение четных чиселю
     * @param start от.
     * @param finish до.
     * @return sum.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }
}