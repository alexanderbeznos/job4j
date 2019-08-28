package ru.job4j.iterator;

import java.util.*;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 28.08.2019.
 */
public class IteratorToArray implements Iterator {
    private final int[][] array;
    private int size;
    private int count = 1;
    private int firstIndex = 0;
    private int secondIndex = 0;

    public IteratorToArray(int[][] array) {
        this.array = array;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                size++;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return count <= size;
    }

    @Override
    public Object next() {
        int result = 0;
        result = array[firstIndex][secondIndex];
        if (++secondIndex == array[firstIndex].length) {
            firstIndex++;
            secondIndex = 0;
        }
        count++;
        return result;
    }
}