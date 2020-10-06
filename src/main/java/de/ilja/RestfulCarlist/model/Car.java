package de.ilja.RestfulCarlist.model;

public class Car {

    private  int id;
    private static int counter = 1000;
    private String model;
    private String brand;
    private String leistung;
    private String baujahr;
    private String motor;
    private String verbrauch;

    public Car() {

    }

    public Car(String model, String brand, String leistung, String baujahr, String motor, String verbrauch) {
        this.model = model;
        this.brand = brand;
        this.leistung = leistung;
        this.baujahr = baujahr;
        this.motor = motor;
        this.verbrauch = verbrauch;
        this.generateId();
    }

    public void generateId() {
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLeistung() {
        return leistung;
    }

    public void setLeistung(String leistung) {
        this.leistung = leistung;
    }

    public String getBaujahr() {
        return baujahr;
    }

    public void setBaujahr(String baujahr) {
        this.baujahr = baujahr;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getVerbrauch() {
        return verbrauch;
    }

    public void setVerbrauch(String verbrauch) {
        this.verbrauch = verbrauch;
    }
}
