package main.java.ru.job4j.compare;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        if (this.getAge() > o.getAge()) {
            return +1;
        } else if (this.getAge() < o.getAge()) {
            return  -1;
        } else {
            return 0;
        }
    }
}
