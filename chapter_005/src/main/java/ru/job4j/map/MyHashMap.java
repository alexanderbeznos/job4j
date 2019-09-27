package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 17.09.2019.
 */
public class MyHashMap<K, V> implements Iterable {
    private Node<K, V>[] container;
    private int size = 0;
    private int modCount = 0;

    public MyHashMap() {
        container = new Node[16];
    }

    private int hash(Object key) {
        int h = 0;
        if (key == null) {
            return h;
        } else {
            h = key.hashCode();
            h = h ^ (h >>> 16);
        }
        return h;
    }

    private int indexFor(int hash) {
        return hash & (container.length - 1);
    }


    public boolean insert(K key, V value) {
        boolean result = false;
        if (size == container.length) {
            increase();
        }
        int hash = hash(key);
        int index = indexFor(hash);
        Node<K, V> old = container[index];
        if (old == null) {
            container[index] = new Node<>(key, value);
            result = true;
            modCount++;
            size++;
        }
        return result;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = indexFor(hash);
        Node<K, V> node = container[index];
        V value = null;
        if (node != null) {
            value = node.value;

        }
        return value;
    }

    public boolean delete(K key) {
        boolean result = false;
        if (container.length > 0) {
            int hash = hash(key);
            int index = indexFor(hash);
            Node<K, V> node = container[index];
            if (node != null && key.equals(node.key)) {
                container[index] = null;
                result = true;
                modCount++;
                size--;
            }
        }
        return result;
    }

    public void increase() {
        Node<K, V>[] a = new Node[container.length * 2];
        System.arraycopy(container, 0, a, 0, container.length - 1);
        container = a;
    }

    public int getSize() {
        return size;
    }

    private class Node<K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int expectedModCount = modCount;
            private int count;
            private int current;

            @Override
            public boolean hasNext() {
                return size > this.count;
            }

            @Override
            public K next() {
                K result = null;

                if (expectedModCount != size) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                for (int i = current; i < container.length; i++) {
                    if (container[i] != null) {
                        count++;
                        current = i + 1;
                        result = container[i].getKey();
                    }
                }
                return result;
            }
        };
    }
}
