package streamapitest;

import org.junit.Test;
import streamapi.*;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 24.08.2019.
 */
public class ListToMapTest {
    @Test
    public void sort() {
        Student a1 = new Student("A", 50);
        Student a2 = new Student("B", 15);
        Student a3 = new Student("C", 51);
        Student a4 = new Student("D", 80);
        List<Student> list1 = List.of(a1, a2, a3, a4);
        Map<String, Student> result = new ListToMap().collectToMap(list1);
        Map<String, Student> expect = Map.of("A", a1, "B", a2, "C", a3, "D", a4);
        assertThat(result, is(expect));
    }

    /**
     * тест с входными параметрами в которых есть дубликаты.
     */
    @Test
    public void sort2() {
        Student a1 = new Student("A", 50);
        Student a2 = new Student("B", 15);
        Student a3 = new Student("C", 51);
        Student a4 = new Student("D", 80);
        Student a5 = new Student("D", 80);
        Student a6 = new Student("D", 80);
        List<Student> list1 = List.of(a1, a2, a3, a4, a5, a6);
        Map<String, Student> result = new ListToMap().collectToMap(list1);
        Map<String, Student> expect = Map.of("A", a1, "B", a2, "C", a3, "D", a4);
        assertThat(result, is(expect));
    }
}
