package ru.job4j.scan;

public class Criteria {
    String[] date;

    public Criteria(String[] date) {
        this.date = date;
    }

    public String directory() {
        return date[0];
    }

    public String name() {
        return date[1];
    }

    public String make() {
        return date[2];
    }

}
