package ru.job4j.collections;



import org.junit.Test;
import ru.job4j.telefon.Person;
import ru.job4j.telefon.PhoneDictionary;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import java.util.List;


public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var persons = phones.find("Petr");
        assertThat(persons.iterator().next().getSurname(), is("Arsentev"));
    }
}