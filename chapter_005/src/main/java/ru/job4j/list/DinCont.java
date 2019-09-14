package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 14.09.2019.
 */
public class DinCont<E> implements Iterable<E> {
    private int modCount;
    private Node<E> first;

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    public void add(E value) {
        Node<E> newLink = new Node<>(value);
        newLink.next = this.first;
        this.first = newLink;
        this.modCount++;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int count;

            @Override
            public boolean hasNext() {
                return modCount > this.count;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> result = first;
                for (int i = 0; i < count; i++) {
                    result = result.next;
                }
                count++;
                return result.value;
            }
        };
    }
}
