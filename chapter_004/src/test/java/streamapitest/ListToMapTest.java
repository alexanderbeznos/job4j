package streamapitest;

import org.junit.Test;
import streamapi.*;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 24.08.2019.
 */
public class ListToMapTest {
    @Test
    public void sort() {
        List<Student> list1 = new ArrayList<>();
        Student a1 = new Student("A", 50);
        Student a2 = new Student("B", 15);
        Student a3 = new Student("C", 51);
        Student a4 = new Student("D", 80);
        Map<String, Student> result = new ListToMap().collectToMap(list1);
        Map<String, Student> expect = new LinkedHashMap<>();
        expect.put("A", a1);
        expect.put("B", a2);
        expect.put("C", a3);
        expect.put("D", a4);
        assertThat(result, is(expect));
    }
}
