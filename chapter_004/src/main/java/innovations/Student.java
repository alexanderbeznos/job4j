package innovations;

import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private Integer scope;

    public Student(String name, Integer scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }

    @Override
    public int compareTo(Student o) {
        return o.scope.compareTo(this.scope);
    }
}
