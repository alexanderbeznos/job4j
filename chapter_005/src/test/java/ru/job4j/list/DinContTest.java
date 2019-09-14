package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 13.09.2019.
 */
public class DinContTest {
    private DinCont<Integer> list;

    @Before
    public void before() {
        list = new DinCont<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenGet() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void hasFalse() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(false));

    }

    @Test(expected = ConcurrentModificationException.class)
    public void thenConcurrentModificationException() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        list.add(25);
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
    }

    @Test(expected = NoSuchElementException.class)
    public void thenNoSuchElementException() {
        Iterator<Integer> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        it.next();
    }
}