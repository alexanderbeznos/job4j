package streamapi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.1.
 * @since 24.08.2019.
 */
public class ListToMap {
    public Map<String, Student> collectToMap(List<Student> students) {
        Set<Student> s = new HashSet<>(students);
        return s.stream().collect(Collectors.toMap(e -> e.getName(), e -> e));
    }
}
