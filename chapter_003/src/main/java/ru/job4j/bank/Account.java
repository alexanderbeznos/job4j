package ru.job4j.bank;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    public boolean transfer(Account to, double money) {
        if (this.getValue() >= money) {
            this.setValue(this.getValue() - money);
            to.setValue(to.getValue() + money);
            return true;
        } else {
            return false;
        }

    }
}
