package ru.job4j.map;

import java.util.HashMap;
import java.util.List;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 15.08.2019.
 */
public class UserConvert {

    /**
     * Метод преобразует лист в мэп
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User o : list) {
            map.put(o.getId(), o);
        }
        return map;
    }
}
