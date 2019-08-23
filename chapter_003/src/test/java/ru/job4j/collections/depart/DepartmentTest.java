package ru.job4j.collections.depart;

import org.junit.Test;
import ru.job4j.depart.Department;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 23.08.2019.
 */
public class DepartmentTest {

    /**
     * тест на добавление верхних подразделнений и сортировки по возростанию.
     */
    @Test
    public void whenFind() {
        Department obj = new Department();
        List<String> list = new ArrayList<>();
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        Set<String> li =  obj.structure(list);
        List<String> re = new ArrayList<>(li);
        String result = re.get(1);
        String expect = "K1\\SK1";
        assertThat(result, is(expect));
    }

    /**
     * тест на сортировку по убываанию.
     */
    @Test
    public void whenLow() {
        Department obj = new Department();
        List<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        Set<String> li =  obj.structure(list);
        List<String> re = new ArrayList<>(li);
        List<String> cons = obj.sortlow(re);
        String result = cons.get(2);
        String expect = "K2\\SK1\\SSK2";
        assertThat(result, is(expect));
        for (String o : cons) {
            System.out.println(o);
        }
    }
    /**
     * тест на сравнений списков.
     */
    @Test
    public void wheCompare() {
        List<String> expect = new ArrayList<>();
        expect.add("K2");
        expect.add("K2\\SK1");
        expect.add("K2\\SK1\\SSK2");
        expect.add("K2\\SK1\\SSK1");
        expect.add("K1");
        expect.add("K1\\SK2");
        expect.add("K1\\SK1");
        expect.add("K1\\SK1\\SSK2");
        expect.add("K1\\SK1\\SSK1");
        Department obj = new Department();
        List<String> list = new ArrayList<>();
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        Set<String> li =  obj.structure(list);
        List<String> re = new ArrayList<>(li);
        List<String> result = obj.sortlow(re);
        assertThat(result, is(expect));




    }
}
