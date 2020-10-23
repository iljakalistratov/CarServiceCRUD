package de.ilja.RestfulCarlist.databases;

import de.ilja.RestfulCarlist.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Integer> {
}
