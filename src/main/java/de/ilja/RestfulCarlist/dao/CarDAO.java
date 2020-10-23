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
    private int counter = 1000;

    @Autowired
    public CarDAO(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarDAO() {

    }

    /**
     * This method generates an ID, when you're creating a new Car object
     * @author Ilja
     */

    public void generateId(Car car) {
        while (carRepository.findById(counter).isPresent()) {
            counter++;
        }
        car.setId(counter);
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
        this.generateId(car);
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

        if (car.getModel() == null) {
            car.setModel(carRepository.findById(id).get().getModel());
        }
        if (car.getBrand() == null) {
            car.setBrand(carRepository.findById(id).get().getBrand());
        }
        if (car.getLeistung() == null) {
            car.setLeistung(carRepository.findById(id).get().getLeistung());
        }
        if (car.getBaujahr() == null) {
            car.setBaujahr(carRepository.findById(id).get().getBaujahr());
        }
        if (car.getMotor() == null) {
            car.setMotor(carRepository.findById(id).get().getMotor());
        }
        if (car.getVerbrauch() == null) {
            car.setVerbrauch(carRepository.findById(id).get().getVerbrauch());
        }

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

    public void clearAllCars() {
        carRepository.deleteAll();
    }


    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }
}

