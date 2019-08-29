package ru.job4j.generic;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.Iterator;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 29.08.2019.
 */
public class SimpleArrayTest {
    @Test
    public void whenAddAndGet() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        assertThat(simpleArray.get(0), is("test1"));
    }

    @Test
    public void whenSet() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.set(1, "test3");
        assertThat(simpleArray.get(1), is("test3"));
    }

    @Test
    public void whenDelete() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test0");
        simpleArray.add("test1");
        simpleArray.add("test2");
        simpleArray.add("test3");
        simpleArray.add("test4");
        simpleArray.remove(1);
        assertThat(simpleArray.get(1), is("test2"));
        assertThat(simpleArray.get(2), is("test3"));
        assertThat(simpleArray.get(3), is("test4"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexInGetWithError() {
        SimpleArray<String> simpleArray = new SimpleArray<>(10);
        simpleArray.add("test1");
        simpleArray.get(1);
    }
}
