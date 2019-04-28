package ru.job4j.array;
/**
 * Массив заполнен true или false.
 * @author Akexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 28.04.2019.
 */
public class Check {
    /**
     * true или false
     * @param data массив.
     * @return возвращает true или false
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 1; index != data.length; index++) {
            if (data[index - 1] != data[index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}