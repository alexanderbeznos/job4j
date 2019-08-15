package main.java.ru.job4j.arrayList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 14.08.2019.
 */
public class ConvertMatrix2List {
    /**
     * Метод записывает в лист двумерный массив.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] out : array) {
            for (int inn : out) {
                list.add(inn);
            }
        }
        return list;
    }

}
