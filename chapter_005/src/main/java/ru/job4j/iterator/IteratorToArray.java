package ru.job4j.iterator;

import java.util.*;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 28.08.2019.
 */
public class IteratorToArray implements Iterator {
    private final int[][] array;
    private int firstIndex = 0;
    private int secondIndex = 0;

    public IteratorToArray(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return firstIndex < array.length;
    }

    @Override
    public Object next() {
        int result = 0;
        try {
            result = array[firstIndex][secondIndex];
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new NoSuchElementException();
        }
        if (++secondIndex == array[firstIndex].length) {
            firstIndex++;
            secondIndex = 0;
        }
        return result;
    }
}