package ru.job4j.profession;

public class Programmer extends Engineer {
    private int numberWritePrograms;
    public Programmer(String name, String surname, String education, int birthday, String experience, int numberWritePrograms) {
        super(name, surname, education, birthday, experience);
        this.numberWritePrograms = numberWritePrograms;
    }
    public Project make(Client client) {
        return new Project();
    }
    public int getNumberWritePrograms() {
        return this.numberWritePrograms;
    }
}
