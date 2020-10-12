package de.ilja.RestfulCarlist.dao;

import de.ilja.RestfulCarlist.model.Car;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarDAO {

    private static Map<Integer, Car> carMap = new HashMap<Integer, Car>();

    static {
        initcars();
    }

    private static void initcars() {
        Car car1 = new Car("Celica", "Toyota", "150", "2004", "1.8 Benzin", "8");
        Car car2 = new Car("A-Klasse", "Mercedes", "150", "2014", "1.8 Diesel", "6");
        Car car3 = new Car("911 Carrera", "Porsche", "385", "2016", "3.0 Benzin", "9.4");

        carMap.put(car1.getId(), car1);
        carMap.put(car2.getId(), car2);
        carMap.put(car3.getId(), car3);
    }

    public Car getCar(int model) {
        return carMap.get(model);
    }

    public Car addCar(Car car) {
        carMap.put(car.getId(), car);
        return car;
    }

    public Car updateCar(Car car, int id) {
        carMap.get(car.getId());

        if (car.getModel() == null) {
            car.setModel(carMap.get(id).getModel());
        }
        if (car.getBrand() == null) {
            car.setBrand(carMap.get(id).getBrand());
        }
        if (car.getLeistung() == null) {
            car.setLeistung(carMap.get(id).getLeistung());
        }
        if (car.getBaujahr() == null) {
            car.setBaujahr(carMap.get(id).getBaujahr());
        }
        if (car.getMotor() == null) {
            car.setMotor(carMap.get(id).getMotor());
        }
        if (car.getVerbrauch() == null) {
            car.setVerbrauch(carMap.get(id).getVerbrauch());
        }

        carMap.put(car.getId(), car);
        return car;
    }

    public void deleteCar(int id) {
        carMap.remove(id);
    }

    public  void resetHashmap() {
        carMap = new HashMap<>();
    }

    public boolean checkForInvalidID(int id) {
        return carMap.get(id) == null;
    }

    public List<Car> getAllCars() {
        Collection<Car> c = carMap.values();
        List<Car> list = new ArrayList<Car>();
        list.addAll(c);
        return list;
    }

}

