package innovationstest;

import org.junit.Test;
import innovations.Student;
import innovations.School;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SchoolTest {
    @Test
    public void levelOfTest() {
        Student student1 = new Student("A", 55);
        Student student2 = new Student("C", 80);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(null);
        list.add(student2);
        List<Student> result = new School().levelOf(list, 70);
        List<Student> except = List.of(student2);
        assertThat(result, is(except));
    }
}
