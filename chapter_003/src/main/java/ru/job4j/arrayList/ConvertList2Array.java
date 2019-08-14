package main.java.ru.job4j.arrayList;

import java.util.Iterator;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 14.08.2019.
 */
public class ConvertList2Array {

    /**
     * Метод записывает лист в двухмерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        Iterator<Integer> iter = list.iterator();
        int[][] array = new int[rows][rows];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (iter.hasNext()) {
                        array[i][j] = iter.next();
                    } else {
                        array[i][j] = 0;
                    }

                }
            }
        return array;
    }
}
