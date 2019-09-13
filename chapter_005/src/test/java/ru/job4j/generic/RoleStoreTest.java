package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 13.09.2019.
 */
public class RoleStoreTest {
    @Test
    public void whenInputRoleThenContainRole() {
        Role first = new Role("1");
        Role second = new Role("2");

        RoleStore cont = new RoleStore(new SimpleArray(10));
        cont.add(first);
        cont.add(second);

        Role third = new Role("3");
        cont.replace("1", third);

        cont.delete("2");

        Role res = cont.findById("3");

        assertThat(res, is(third));
    }
}