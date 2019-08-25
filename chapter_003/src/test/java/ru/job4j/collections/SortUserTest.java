package ru.job4j.collections;

import ru.job4j.compare.SortUser;
import ru.job4j.compare.User;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    /**
     * Проверяет сортировку User.
     */
    @Test
    public void whenListToMap() {
        SortUser a = new SortUser();
        //Set<User> result = a.sort(Arrays.asList(new User("Sanya", 2), new User("Igor", 1)));
        Set<User> result = a.sort(List.of(new User("Sanya", 2), new User("Igor", 1)));
        String expect = "Igor";
        assertThat(result.iterator().next().getName(), is(expect));
    }

    /**
     * Проверяет сортировку User по длине имени.
     */
    @Test
    public void whenNameLength() {
        SortUser a = new SortUser();
        List<User> result = a.sortNameLength(Arrays.asList(new User("Sanya", 2),
                new User("Alexander", 1)));
        String expect = "Sanya";
        assertThat(result.iterator().next().getName(), is(expect));
    }



    /**
     * Проверяет сортировку User по имени и возрасту.
     */
    @Test
    public void whenNameandAge() {
        SortUser a = new SortUser();
        List<User> result = a.sortByAllFields(Arrays.asList(new User("Сергей", 25), new User("Иван", 30),
                new User("Сергей", 20), new User("Иван", 25)));
        int expect = 25;
        assertThat(result.iterator().next().getAge(), is(expect));
    }




}
