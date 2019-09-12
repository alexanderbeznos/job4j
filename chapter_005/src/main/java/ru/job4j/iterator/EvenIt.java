package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator {
    private int index = 0;
    final int[] numbers;
    public EvenIt(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean bool = false;
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                bool = true;
                index = i;
                break;
            }
        }
        return bool;
    }

    @Override
    public Object next() {
        if (hasNext()) {
            return numbers[index++];
        } else {
            throw new NoSuchElementException();
        }
    }
}
