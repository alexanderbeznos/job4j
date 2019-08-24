package streamapitest;

import org.junit.Test;
import streamapi.School;
import streamapi.Student;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Alexander Beznos (ast1bn@mail.ru).
 * @version 1.0.
 * @since 23.08.2019.
 */

public class SchoolTest {
    /*
    @Test
    public void whenA() {
        Student student1 = new Student(14);
        Student student2 = new Student(52);
        Student student3 = new Student(75);
        Student student4 = new Student(90);
        List<Student> students = List.of(student1, student2, student3, student4);
        Predicate<Student> predicate = s -> s.getScore() <= 100 && s.getScore() >= 70;
        List<Student> result = new School().collect(students, predicate);
        List<Student> except = List.of(student3, student4);
        assertThat(result, is(except));
    }
    @Test
    public void whenB() {
        Student student1 = new Student(14);
        Student student2 = new Student(52);
        Student student3 = new Student(69);
        Student student4 = new Student(90);
        List<Student> students = List.of(student1, student2, student3, student4);
        Predicate<Student> predicate = s -> s.getScore() < 70 && s.getScore() >= 50;
        List<Student> result = new School().collect(students, predicate);
        List<Student> except = List.of(student2, student3);
        assertThat(result, is(except));
    }
    @Test
    public void whenC() {
        Student student1 = new Student(14);
        Student student2 = new Student(47);
        Student student3 = new Student(90);
        Student student4 = new Student(15);
        List<Student> students = List.of(student1, student2, student3, student4);
        Predicate<Student> predicate = s -> s.getScore() < 50 && s.getScore() > 0;
        List<Student> result = new School().collect(students, predicate);
        List<Student> except = List.of(student1, student2, student4);
        assertThat(result, is(except));
    }
     */
 }
