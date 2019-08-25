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
        return students.stream().collect(Collectors.toMap(e -> e.getName(), e -> e,
                (e1, e2) -> e1));
    }
}
