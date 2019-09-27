package ru.job4j.map;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 17.09.2019.
 */
public class MyHashMapTest {
    private MyHashMap<String, Integer> map;

    @Before
    public void beforeTest() {
        map = new MyHashMap<>();
        map.insert("1", 1);
        map.insert("2", 2);
        map.insert("3", 3);
        map.insert("4", 4);
        map.insert("5", 5);
        map.insert("6", 6);
    }

    @Test
    public void whenInsert() {
        assertThat(map.getSize(), is(6));

    }

    @Test
    public void whenGetAndInsert() {
        assertThat(map.get("6"), is(6));
        assertThat(map.insert("6", 6), is(false));
    }

    @Test
    public void whenDelete() {
        assertThat(map.delete("6"), is(true));
        assertThat(map.insert("6", 6), is(true));
    }

//    @Test
//    public void hasNext() {
//        Iterator<String> it = map.iterator();
//        assertThat(it.hasNext(), Matchers.is(true));
//        assertThat(it.next(), Matchers.is("1"));
//        assertThat(it.hasNext(), Matchers.is(true));
//        assertThat(it.next(), Matchers.is("2"));
//        assertThat(it.hasNext(), Matchers.is(true));
//        assertThat(it.next(), Matchers.is("3"));
//        assertThat(it.hasNext(), Matchers.is(true));
//        assertThat(it.next(), Matchers.is("4"));
//        assertThat(it.hasNext(), Matchers.is(true));
//        assertThat(it.next(), Matchers.is("5"));
//        assertThat(it.hasNext(), Matchers.is(true));
//        assertThat(it.next(), Matchers.is("6"));
//        assertThat(it.hasNext(), Matchers.is(false));
//    }
}
