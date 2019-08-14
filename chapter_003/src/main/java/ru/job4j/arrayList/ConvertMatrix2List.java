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
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }
}
