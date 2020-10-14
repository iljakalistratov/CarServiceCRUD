package de.ilja.RestfulCarlist.controller;

import de.ilja.RestfulCarlist.dao.CarDAO;
import de.ilja.RestfulCarlist.model.Car;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ApiOperation(value = "/carlist", tags = "MainRESTController")
@RestController
public class MainRESTController {

    @Autowired
    public CarDAO carDAO;

    @Autowired
    public MainRESTController(CarDAO carDao) {
        this.carDAO = carDao;
    }

    private static final Logger LOGGER = LogManager.getLogger(MainRESTController.class);

    @GetMapping("/")

    public String startscreen() {
        return "CarService Application by Ilja Kalistratov";
    }



    @GetMapping(value = "/carlist")
    public ResponseEntity<?> showCarlist() {
        LOGGER.debug("GET Request | List all cars");
        return new ResponseEntity<>(carDAO.getAllCars(), HttpStatus.OK);
    }



    @GetMapping(value = "/car/{id}")
    public ResponseEntity<Car> readSingleAutomobile(@PathVariable(value = "id") int id) {
        if (carDAO.isInvalidID(id))
            return incorrectParameterResponse2();
        LOGGER.debug("GET Request | Show slected car");
        return new ResponseEntity<Car>(carDAO.getCar(id), HttpStatus.OK);

    }

    @GetMapping(value = "/car")
    public static ResponseEntity<String> noIDAndSlash() {
        return new ResponseEntity<>("You did not provide an ID", HttpStatus.BAD_REQUEST);
    }


    @PostMapping(value = "/car", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCar(@RequestBody Car carJson) {
        LOGGER.debug("POST Request | carJson");
        carDAO.addCar(carJson);
        LOGGER.info("POST Request | Succesfully added Car to the list");
        return new ResponseEntity<>("Created car with ID: " + carJson.getId(), HttpStatus.OK);
    }



    @PutMapping(value = "/car/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCar (@RequestBody Car carJson,
                                             @PathVariable("id") int id) {
        if (id == 0 || carDAO.isInvalidID(id) ) {
            LOGGER.error("PUT Request | ID " + id + " does not exist");
            return incorrectParameterResponse();
        }
        LOGGER.debug("PUT Request | Change or add properties of an existing car");
        carJson.setId(id);
        carDAO.updateCar(carJson, id);
        LOGGER.info("PUT Request | Succesfully edited porperties of car " + id);
        return new ResponseEntity<>("Updated :" + id, HttpStatus.OK);
    }



    @DeleteMapping(value = "/car/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable(value = "id") int id) {
        if (id == 0 || carDAO.isInvalidID(id)) {
            LOGGER.error("DELETE Request | No car found with ID: " + id);
            return incorrectParameterResponse();
        }
        carDAO.deleteCar(id);
        LOGGER.info("DELETE Request | Succesfully deleted car: " + id);
        return new ResponseEntity<>("Deleted: " + id, HttpStatus.NO_CONTENT);
    }


    public static ResponseEntity<String> incorrectParameterResponse() {
        return new ResponseEntity<String>("This ID does not exist", HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Car> incorrectParameterResponse2() {
        return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
    }


}
