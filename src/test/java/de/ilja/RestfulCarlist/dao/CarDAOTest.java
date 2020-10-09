package de.ilja.RestfulCarlist.dao;

import de.ilja.RestfulCarlist.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
//        Car car1 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
//        Car car2 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
//        carDao.addCar(car1);
//        carDao.updateCar(car1, car1.getId());

//        car1.updatCra("Supra");
//        assertEquals("Supra", car1.getModel());
//        car1.setBrand(null);
//        assertEquals("Toyota", car1.getBrand());
    }

    @Test
    void deleteCar() {
    }

    @Test
    void getAllCars() {
    }
}