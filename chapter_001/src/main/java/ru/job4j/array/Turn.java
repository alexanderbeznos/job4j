package ru.job4j.array;
/**
 * Возвращает перевёрнутый массив.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 28.04.2019.
 */
public class Turn {
    /**
     * перевёрнутый массив.
     * @param array массив.
     * @return перевёрнутый массив.
     */
    public int[] back(int[] array) {
        for (int index = 0; index < array.length - index; index++) {
            int t = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = t;
        }
        return array;
    }
}