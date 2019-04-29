package ru.job4j.array;
/**
 * Таблица умножения.
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 29.04.2019.
 */
public class Matrix {
    /**
     * Умножение.
     * @param size размер.
     * @return перемноженные значения.
     */
       public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i != size + 1; i++) {
            for (int j = 1; j != size + 1; j++) {
                table [i - 1] [j - 1] = i * j;
            }
        }
        return table;
    }
}