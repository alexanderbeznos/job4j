package ru.job4j.collections;


import org.junit.Test;
import ru.job4j.map.User;
import ru.job4j.map.UserConvert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenListToMap() {
        UserConvert a = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User(1, "Igor", "Tero"));
        list.add(new User(2, "Vasya", "Poru"));
        HashMap<Integer, User> maper = a.process(list);
        String expect = "Tero";
        assertThat(maper.get(1).getCity(), is(expect));
    }
}
