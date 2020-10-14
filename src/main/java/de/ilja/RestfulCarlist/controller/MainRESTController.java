package de.ilja.RestfulCarlist.controller;

import de.ilja.RestfulCarlist.dao.CarDAO;
import de.ilja.RestfulCarlist.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRESTController {

    @Autowired
    public CarDAO carDAO;

    @Autowired
    public MainRESTController(CarDAO carDao) {
        this.carDAO = carDao;
    }

    @RequestMapping("/")
    @ResponseBody
    public String startscreen() {
        return "CarService Application by Ilja Kalistratov";
    }



    @RequestMapping(value = "/carlist")
    public ResponseEntity<?> showCarlist() {
        return new ResponseEntity<>(carDAO.getAllCars(), HttpStatus.OK);
    }


    @RequestMapping(value = "/car/{id}")
    @GetMapping
    public ResponseEntity<Car> readSingleAutomobile(@PathVariable(value = "id") int id) {
        if (carDAO.isInvalidID(id))
            return incorrectParameterResponse2();
        return new ResponseEntity<Car>(carDAO.getCar(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/car")
    public static ResponseEntity<String> noIDAndSlash() {
        return new ResponseEntity<>("You did not provide an ID", HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/car", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCar(@RequestBody Car carJson) {
        carDAO.addCar(carJson);
        return new ResponseEntity<>("Created car with ID: " + carJson.getId(), HttpStatus.OK);
    }



    @PutMapping(value = "/car/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCar (@RequestBody Car carJson,
                                             @PathVariable("id") int id) {
        if (id == 0 || carDAO.isInvalidID(id) ) {
            return incorrectParameterResponse();
        }
        carJson.setId(id);
        carDAO.updateCar(carJson, id);
        return new ResponseEntity<>("Updated :" + id, HttpStatus.OK);
    }



    @DeleteMapping(value = "/car/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable(value = "id") int id) {
        if (id == 0 || carDAO.isInvalidID(id)) {
            return incorrectParameterResponse();
        }
        carDAO.deleteCar(id);
        return new ResponseEntity<>("Deleted: " + id, HttpStatus.NO_CONTENT);
    }


    public static ResponseEntity<String> incorrectParameterResponse() {
        return new ResponseEntity<String>("This ID does not exist", HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Car> incorrectParameterResponse2() {
        return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
    }


}
