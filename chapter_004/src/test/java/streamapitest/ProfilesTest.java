package streamapitest;

import org.junit.Test;
import streamapi.*;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 24.08.2019.
 */
public class ProfilesTest {
    /**
     * Тест а сортировку по городу.
     */
    @Test
    public void sort() {
        List<Profile> list1 = new ArrayList<>();
        Address a1 = new Address("Mos", "Lomos", 10, 45);
        Address a5 = new Address("Mos", "Lomos", 10, 45);
        Address a6 = new Address("Mos", "Lomos", 10, 45);
        Address a2 = new Address("Vol", "Trew", 25, 15);
        Address a3 = new Address("Peter", "Hert", 47, 85);
        Address a4 = new Address("Symf", "Poer", 40, 38);
        list1.add(new Profile(a1));
        list1.add(new Profile(a2));
        list1.add(new Profile(a3));
        list1.add(new Profile(a4));
        list1.add(new Profile(a5));
        list1.add(new Profile(a6));
        List<Address> result = new Profiles().collect(list1);
        List<Address> except = List.of(a1, a3, a4, a2);
        assertThat(result, is(except));
    }


}
