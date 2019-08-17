package ru.job4j.compare;

import java.util.*;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 16.08.2019.
 */
public class SortUser {

    /**
     * Метод организрвывает сортировку User..
     */
    public Set<User> sort(List<User> list) {
        Set<User> set = new TreeSet<>(list);
        return set;
    }

    /**
     * Сортировка по длине имени.
     */
    public List<User> sortNameLength(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    /**
     * Сортировка по длине имени и по возрасту.
     */
    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int a = Integer.compare(o1.getName().length(), o2.getName().length());
                return a != 0 ? a : Integer.compare(o1.getAge(), o2.getAge());

            }
        });
        return list;
    }


}
