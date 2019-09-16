package ru.job4j.list;

import java.util.Iterator;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 15.09.2019.
 */
public class SimpleStack<T> {
    private DinCont dinCont = new DinCont();

    public T poll() {
        return (T) dinCont.delete();
    }

    public void push(T value) {
       dinCont.add(value);
    }

    public int getSize() {
        return dinCont.getModCount();
    }
}