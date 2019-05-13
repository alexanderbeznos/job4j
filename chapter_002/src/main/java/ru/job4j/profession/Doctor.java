package ru.job4j.profession;

public class Doctor extends Profession {
    private String numberHospital;
    private String numberRoom;
    public Doctor (String name, String surname, String education, int birthday, String numberHospital, String numberRoom ) {
        super(name, surname, education, birthday);
        this.numberHospital = numberHospital;
        this.numberRoom = numberRoom;
    }
    public Diagnose heal(Pacient pacient) {
        return new Diagnose();
    }
    public String getNumberHospital() {
        return this.numberHospital;
    }
    public String getNumberRoom() {
        return this.numberRoom;
    }
}
