package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 14.09.2019.
 */
public class CycleTest {
    private Cycle cycly;

    @Test
    public void thanHasCycleWhenTrue() {
        cycly = new Cycle();
        Cycle.Node<Integer> first = new Cycle.Node<>(1);
        Cycle.Node<Integer> second = new Cycle.Node<>(2);
        Cycle.Node<Integer> third = new Cycle.Node<>(3);
        Cycle.Node<Integer> four = new Cycle.Node<>(4);
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = first;
        assertThat(cycly.hasCycle(first), is(true));
    }

    @Test
    public void thanHasCycleWhenfalse() {
        cycly = new Cycle();
        Cycle.Node<Integer> first = new Cycle.Node<>(1);
        Cycle.Node<Integer> second = new Cycle.Node<>(2);
        Cycle.Node<Integer> third = new Cycle.Node<>(3);
        Cycle.Node<Integer> four = new Cycle.Node<>(4);
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = null;
        assertThat(cycly.hasCycle(first), is(false));
    }
}
