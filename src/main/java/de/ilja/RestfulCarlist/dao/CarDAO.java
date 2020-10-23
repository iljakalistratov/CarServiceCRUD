package de.ilja.RestfulCarlist.dao;

import de.ilja.RestfulCarlist.databases.CarRepository;
import de.ilja.RestfulCarlist.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Consumer;

@Component
public class CarDAO implements Iterable {

    private CarRepository carRepository;


    @Autowired
    public CarDAO(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarDAO() {

    }


    /**
     *
     * @param id
     * @return Returns Car object from the map with the given id
     */
    public Car getCar(int id) {
        return carRepository.findById(id).get();
    }

    /**
     * This method adds a new Car to the map
     * @param car
     * @return new car object
     */
    public Car addCar(Car car) {
        car.generateId();
        carRepository.save(car);
        return car;
    }

    /**
     * This method edits an existing car and takes previous parameters, if new parameters aren't given.
     * The ID cannot be edited/changed.
     * @param car
     * @param id
     * @return edited car object
     */
    public Car updateCar(Car car, int id) {

//        if (car.getModel() == null) {
//            car.setModel(carMap.get(id).getModel());
//        }
//        if (car.getBrand() == null) {
//            car.setBrand(carMap.get(id).getBrand());
//        }
//        if (car.getLeistung() == null) {
//            car.setLeistung(carMap.get(id).getLeistung());
//        }
//        if (car.getBaujahr() == null) {
//            car.setBaujahr(carMap.get(id).getBaujahr());
//        }
//        if (car.getMotor() == null) {
//            car.setMotor(carMap.get(id).getMotor());
//        }
//        if (car.getVerbrauch() == null) {
//            car.setVerbrauch(carMap.get(id).getVerbrauch());
//        }

        carRepository.save(car);
        return car;
    }

    /**
     * This method deletes an existing car object.
     * @param id
     */
    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }


    /**
     * Checks for invalid ID
     * @param id
     * @return null, if ID is invalid
     */
    public boolean isInvalidID(int id) {
        return carRepository.findById(id) == null;
    }

    /**
     * Gets all cars in form of a list
     * @return list, with all cars
     */
    public List<Car> getAllCars() {
//        carRepository.findAll();
//        Collection<Car> c = carMap.values();
        List<Car> list = new ArrayList<Car>();
        carRepository.findAll().forEach(list::add);
//        list.addAll(c);
        return list;
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }
}

