package ru.job4j.profession;

public class Surgeon extends Doctor {
    private String nameOfEmployee;
    public Surgeon(String name, String surname, String education, int birthday, String numberHospital, String numberRoom, String nameOfEmployee) {
        super(name, surname, education, birthday, numberHospital, numberRoom);
        this.nameOfEmployee = nameOfEmployee;
        public boolean liveInCity() {
            return true;
        }
        public String getNameOfEmployee() {
            return this.nameOfEmployee;
        }
    }
}