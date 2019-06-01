package ru.job4j.profession;

public class Engineer extends Profession {
    private String experience;
    public Engineer(String name, String surname, String education, int birthday, String experience) {
        super(name, surname, education, birthday);
        this.experience = experience;
    }
    public boolean draw() {
        return true;
    }
    public String getExpereence() {
        return this.experience;
    }
}
