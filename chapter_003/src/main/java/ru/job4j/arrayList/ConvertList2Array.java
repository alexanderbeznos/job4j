package main.java.ru.job4j.arrayList;

import java.util.Iterator;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 14.08.2019.
 */
public class ConvertList2Array {

    /**
     * Метод записывает лист в двухмерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) (Math.ceil((double) list.size() / rows));
        int[][] array = new int[rows][cells];
        int row = 0;
        int cell = 0;
        for (Integer o : list) {
            array[row][cell] = o;
            cell++;
            if (cell == cells) {
                cell = 0;
                row++;
            }
        }
        return array;
    }
}