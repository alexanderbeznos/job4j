package ru.job4j.list;

import java.util.*;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 14.09.2019.
 */
public class DinList<E> implements Iterable<E> {
    private Object[] container;
    private int modCount = 0;
    private int size = 0;

    public DinList() {
        this.container = new Object[10];
    }

    public int size() {
        return size;
    }

    public void add(E value) {
        if (this.container.length == this.modCount) {
            containerIncrease();
        }
        modCount++;
        this.container[size++] = value;
    }

    public void containerIncrease() {
        this.container = Arrays.copyOf(this.container, this.container.length + 10);
    }

    public E get(int index) {
        E result = null;
        if (this.size >= index) {
            result = (E) this.container[index];
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private int count;

            @Override
            public boolean hasNext() {
                return size > this.count;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) container[count++];
            }
        };
    }
}
