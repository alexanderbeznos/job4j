package ru.job4j.array;
/**
 * Нахождение числа в массиве.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 27.04.2019.
 */
public class FindLoop {
    /**
     * вычичление.
     * @param date массивю
     * @param el искомый элемент.
     * @return возврат искомого элемента.
     */
    public int indexOf(int[] date, int el) {
        int rst = -1;
        for (int index = 0; index != date.length; index++) {
            if (date[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
