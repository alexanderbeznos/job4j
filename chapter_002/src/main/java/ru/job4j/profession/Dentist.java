package ru.job4j.profession;

public class Dentist extends Doctor {
    private int costOfEquipment;
    public Dentist(String name, String surname, String education, int birthday, String numberHospital, String numberRoom, int costOfEquipment) {
        super(name, surname, education, birthday, numberHospital, numberRoom);
        this.costOfEquipment = costOfEquipment;
        public int seal() {
            return 1;
        }
        public int getCostOfEquipment() {
            return this.costOfEquipment;
        }
    }
}
