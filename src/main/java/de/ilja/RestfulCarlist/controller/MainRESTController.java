package de.ilja.RestfulCarlist.controller;

import de.ilja.RestfulCarlist.dao.CarDAO;
import de.ilja.RestfulCarlist.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainRESTController {

    @Autowired
    private CarDAO carDAO;

    @RequestMapping("/")
    @ResponseBody
    public String startscreen() {
        return "CarService Application by Ilja Kalistratov";
    }


    @RequestMapping(value = "/carlist",
        method = RequestMethod.GET,
        produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Car> getCar() {
        List<Car> list = carDAO.getAllCars();
        return list;
    }


//    @RequestMapping(value = "/car/{id}",
//        method = RequestMethod.GET)
//    @ResponseBody
//    public Car getCar(@PathVariable("id") int id) {
//        return carDAO.getCar(id);
//    }

    @RequestMapping(value = "/car/{id}")
    @GetMapping
    public ResponseEntity<?> readSingleAutomobile(@PathVariable(value = "id") int id) {
        if (carDAO.checkForInvalidID(id))
            return incorrectParameterResponse();
        return new ResponseEntity<>(carDAO.getCar(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/car")
    public static ResponseEntity<String> noIDAndSlash() {
        return new ResponseEntity<String>("You did not provide an ID", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/car",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Car addCar(@RequestBody Car car) {
        System.out.println("(Server Side) Creating new car: " + car.getModel());
        car.generateId();

        return carDAO.addCar(car);
    }


    @RequestMapping(value = "/car/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Car updateCar(@RequestBody Car car, @PathVariable("id") int id) {
        car.setId(id);
        System.out.println("(Server Side) Updating car: " + car.getModel());

        return carDAO.updateCar(car, id);
    }


    @RequestMapping(value = "/car/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteCar(@PathVariable("id") int id) {
        System.out.println("(Server Side) Deleting car: " + id);

        carDAO.deleteCar(id);
    }

    public static ResponseEntity<String> incorrectParameterResponse() {
        return new ResponseEntity<String>("This ID does not exist", HttpStatus.BAD_REQUEST);
    }


}
