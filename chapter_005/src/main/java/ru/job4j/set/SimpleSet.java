package ru.job4j.set;

import ru.job4j.list.DinList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private DinList dinList = new DinList();

    public void add(E value) {
        if (!contains(value)) {
            dinList.add(value);
        }
    }

    public boolean contains(E e) {
        boolean result = false;
        for (int i = 0; i < dinList.size(); i++) {
            if (Objects.equals(dinList.get(i), e)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int size() {
        return dinList.size();
    }

    @Override
    public Iterator<E> iterator() {
        return dinList.iterator();
    }

}
