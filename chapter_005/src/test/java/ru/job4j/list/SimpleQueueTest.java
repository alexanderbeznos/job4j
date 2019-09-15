package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 15.09.2019.
 */
public class SimpleQueueTest {
    SimpleQueue list = new SimpleQueue<>();
    @Before
    public void before() {
        list.push(1);
        list.push(2);
        list.push(3);
    }

    @Test
    public void whenPull() {
        assertThat(list.poll(), is(1));
        assertThat(list.poll(), is(2));
        assertThat(list.poll(), is(3));
    }
}