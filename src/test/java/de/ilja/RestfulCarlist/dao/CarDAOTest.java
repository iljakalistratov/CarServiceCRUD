package de.ilja.RestfulCarlist.dao;

import de.ilja.RestfulCarlist.databases.CarRepository;
import de.ilja.RestfulCarlist.model.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CarDAOTest {



    private static Car car1 = Mockito.mock(Car.class);
    private static CarRepository carRepository1 = Mockito.mock(CarRepository.class);
    CarDAO carDao = new CarDAO(carRepository1);

    @BeforeAll
    static void setter() {
        Mockito.when(car1.getId()).thenReturn(1000);
        Mockito.when(carRepository1.findById(Mockito.anyInt())).thenReturn(Optional.empty());
    }


    @Test
    void addCar() {


    }

    @Test
    void updateCar() {
        Car car2 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
        Car car3 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
        carDao.addCar(car2);
        carDao.updateCar(car2, car2.getId());
        car3.setModel("Supra");
        car3.setBrand("Toyota");
        car3.setLeistung("150");
        car3.setBaujahr("2004");
        car3.setMotor("1.8 Benzin");
        car3.setVerbrauch("8");
        assertNotEquals(car2.getModel(), car3.getModel());
    }

    @Test
    void deleteCar() {
        Mockito.when(carRepository1.existsById(Mockito.anyInt())).thenReturn(true);
        Mockito.when(carRepository1.findById(Mockito.anyInt())).thenReturn(Optional.of(car1));
        carDao.deleteCar(1000);
        Mockito.verify(carRepository1, Mockito.times(1)).deleteById(Mockito.anyInt());
    }
}