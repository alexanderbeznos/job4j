package ru.job4j.profession;

public class Builder extends Engineer {
    private int numberOfWorker;
    public Builder (String name, String surname, String education, int birthday, String experience, int numberOfWorker) {
        super(name, surname, education, birthday, experience);
        this.numberOfWorker = numberOfWorker;
    }
    public boolean years(int age) {
        return true;
    }
    public int getNumberOfWorker() {
        return this.numberOfWorker;
    }
}
