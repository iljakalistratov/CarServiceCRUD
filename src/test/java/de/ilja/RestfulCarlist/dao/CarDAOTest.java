package de.ilja.RestfulCarlist.dao;

import de.ilja.RestfulCarlist.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarDAOTest {

    CarDAO carDao = new CarDAO();

    @Test
    void getCar() {
        Car car1 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
        carDao.addCar(car1);
        assertEquals(carDao.getCar((car1.getId())), car1);
    }

    @Test
    void addCar() {
        Car car1 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
        carDao.addCar(car1);
        assertNotNull(carDao.getCar(car1.getId()));

    }

    @Test
    void updateCar() {
        Car car1 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
        Car car2 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
        carDao.addCar(car1);
        carDao.updateCar(car2, car1.getId());
        car1.setModel("Supra");
        car1.setBrand("Toyota");
        car1.setLeistung("150");
        car1.setBaujahr("2004");
        car1.setMotor("1.8 Benzin");
        car1.setVerbrauch("8");
        assertNotEquals(car2.getModel(), car1.getModel());
    }

    @Test
    void deleteCar() {
        Car car1 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
        carDao.addCar(car1);
        carDao.deleteCar(car1.getId());
        assertNull(carDao.getCar(car1.getId()));
    }

    @Test
    void getAllCars() {

        carDao.resetHashmap();

        Car car1 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
        Car car2 = new Car("A-Klasse", "Mercedes", "150", "2014", "1.8 Diesel", "6");
        Car car3 = new Car("911 Carrera", "Porsche", "385", "2016", "3.0 Benzin", "9.4");
        Car car4 = new Car("911 Carrera", "Porsche", "385", "2016", "3.0 Benzin", "9.4");

        carDao.addCar(car1);
        carDao.addCar(car2);
        carDao.addCar(car3);
        carDao.addCar(car4);
        System.out.println(carDao.getAllCars());
        assertEquals(4, carDao.getAllCars().size());

    }
}