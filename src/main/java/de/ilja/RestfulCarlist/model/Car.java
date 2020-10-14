package de.ilja.RestfulCarlist.model;


import io.swagger.annotations.ApiModelProperty;

public class Car {

    @ApiModelProperty(notes = "ID of the car", name = "id", required = true, value = "234567")
    private  int id;
    private static int counter = 1000;
    @ApiModelProperty(notes = "model of the car", name = "model", required = true, value = "Supra")
    private String model;
    @ApiModelProperty(notes = "brand of the car", name = "brand", required = true, value = "Toyota")
    private String brand;
    @ApiModelProperty(notes = "leistung of the car", name = "leistung", required = true, value = "700")
    private String leistung;
    @ApiModelProperty(notes = "baujahr of the car", name = "baujahr", required = true, value = "2010")
    private String baujahr;
    @ApiModelProperty(notes = "motor of the car", name = "motor", required = true, value = "2 Benzin")
    private String motor;
    @ApiModelProperty(notes = "verbrauch of the car", name = "verbrauch", required = true, value = "12")
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

    public void setId(int id) {
        this.id = id;
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
