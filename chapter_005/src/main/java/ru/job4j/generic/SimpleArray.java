package ru.job4j.generic;

import java.util.Iterator;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 29.08.2019.
 */
public class SimpleArray<T> implements Iterator {
    private Object[] objects;
    int index = 0;

    public SimpleArray(int num) {
        this.objects = new Object[num];
    }

    public void add(T value) {
        if (index == this.objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.objects[index++] = value;
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public void remove(int ind) {
        int a = ind;
        for (int i = ind; i < objects.length - 1; i++) {
            objects[i] = objects[i + 1];
            a++;
        }
        objects[a] = null;
    }

    public T get(int ind) {
        if (ind < 0 || ind >= index) {
            throw new IndexOutOfBoundsException();
        }
        return (T) objects[ind];
    }

    @Override
    public boolean hasNext() {
        return objects.length > index;
    }

    @Override
    public Object next() {
        return (T) objects[index++];
    }

}
