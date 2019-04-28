package ru.job4j.array;
/**
 * Сортировка методом перестановки.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 28.04.2019.
 */
public class BubbleSort {
    /**
     * Сортировка
     * @param numbs массив.
     * @return возврат упорядоченного массива.
     */
    public int[] pooz(int[] numbs) {
        for (int index = 1; index != numbs.length; index++) {
            for (int index2 = numbs.length - 1; index2 >= index; index2--) {
                if (numbs[index2 - 1] > numbs[index2]) {
                    int t = numbs[index2 - 1];
                    numbs[index2 - 1] = numbs[index2];
                    numbs[index2] = t;
                }
            }
        }
        return numbs;
    }
}
