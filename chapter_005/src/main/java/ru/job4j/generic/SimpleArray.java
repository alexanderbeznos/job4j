package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 13.09.2019.
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
        if (objects.length > index) {
            objects[index] = model;
        }
    }

    public void remove(int ind) {
        if (objects.length > ind) {
            System.arraycopy(objects, ind + 1, objects, ind, objects.length - 1 - ind);
            this.index--;
        }
    }

    public T get(int ind) {
        if (ind < 0 || ind >= index) {
            throw new IndexOutOfBoundsException();
        }
        return (T) objects[ind];
    }

    @Override
    public boolean hasNext() {
        if (objects.length <= index) {
            throw new NoSuchElementException();
        }
        return true;
    }

    @Override
    public Object next() {
        return (T) objects[index++];
    }

    public int siz() {
        return objects.length;
    }
}
