package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0
 * @since 16.09.2019.
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public int getChildren() {
        return children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public static void main(String[] args) {
        User user1 = new User("user1", 25, new GregorianCalendar(1994, 5, 15));
        User user2 = new User("user1", 25, new GregorianCalendar(1994, 5, 15));
        Map<User, Integer> map = new HashMap<>();
        map.put(user1, 1);
        map.put(user2, 2);
        for (Map.Entry<User, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
