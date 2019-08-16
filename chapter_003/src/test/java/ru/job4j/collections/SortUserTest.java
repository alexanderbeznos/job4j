package test.java.ru.job4j.collections;

import main.java.ru.job4j.compare.SortUser;
import main.java.ru.job4j.compare.User;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenListToMap() {
        SortUser a = new SortUser();
        Set<User> result = a.sort(Arrays.asList(new User("Sanya",2), new User("Igor",1)));
        String expect = "Igor";
        assertThat(result.iterator().next().getName(), is(expect));
    }

}
