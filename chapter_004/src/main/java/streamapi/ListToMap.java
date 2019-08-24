package streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 24.08.2019.
 */
public class ListToMap {
    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(e -> e.getName(), e -> e));
    }
}
