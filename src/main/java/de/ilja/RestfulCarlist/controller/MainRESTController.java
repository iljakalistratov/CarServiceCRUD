package de.ilja.RestfulCarlist.controller;

import de.ilja.RestfulCarlist.dao.CarDAO;
import de.ilja.RestfulCarlist.databases.CarRepository;
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

/**
 * Main Controller Class for Http requests & CRUD operations
 * author Ilja
 */
@ApiOperation(value = "/car", tags = "MainRESTController")
@RestController
public class MainRESTController {

    @Autowired
    public CarDAO carDAO;

    @Autowired
    public MainRESTController(CarDAO carDao) {
        this.carDAO = carDao;
    }

    private static final Logger LOGGER = LogManager.getLogger(MainRESTController.class);


    /**
     * GET Mapping for "localhost:8080/"
     * @return Returns Basic Information about this application
     */
    @ApiOperation(
            value = "Show startscreen",
            notes = "Shows basic information",
            response = Car.class
    )
    @GetMapping("/")
    public String startscreen() {
        return "CarService Application by Ilja Kalistratov";
    }

    /**
     *
     * This method shows you the whole list of all cars
     * @return List of all cars
     */
    @ApiOperation(
            value = "Show the list of cars",
            notes = "Shows a list of all cars in your list with all parameters and information",
            response = Car.class
    )
    @GetMapping(value = "/carlist")
    public ResponseEntity<?> showCarlist() {
        LOGGER.debug("GET Request | List all cars");
        return new ResponseEntity<>(carDAO.getAllCars(), HttpStatus.OK);
    }

    /**
     *
     *  This method shows all information about a single car.
     * @param id
     * @return information/parameters of one single car object
     */
    @ApiOperation(
            value = "Show single Automobile",
            notes = "Shows all information about the selected automobile",
            response = Car.class
    )
    @GetMapping(value = "/car/{id}")
    public ResponseEntity<Car> readSingleAutomobile(@PathVariable(value = "id") int id) {
        if (carDAO.isInvalidID(id))
            return incorrectParameterResponse2();
        LOGGER.debug("GET Request | Show slected car");
        return new ResponseEntity<Car>(carDAO.getCar(id), HttpStatus.OK);

    }

    /**
     * ErrorHandling if no ID is given
     * @return Errormessage and HTTP: Bad request
     */
    @ApiOperation(
            value = "Show Error Message if no ID is given",
            notes = "Shows an error message",
            response = Car.class
    )
    @GetMapping(value = "/car")
    public static ResponseEntity<String> noIDAndSlash() {
        return new ResponseEntity<>("You did not provide an ID", HttpStatus.BAD_REQUEST);
    }

    /**
     * Generates new car
     * @param carJson
     * @return ID of the new created car and HTTP: Ok
     */
    @ApiOperation(
            value = "Add new Car to the list",
            notes = "You can add a new car to the list, if you write a car json into the Body, the ID will be generated automatically",
            response = Car.class
    )
    @PostMapping(value = "/car", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCar(@RequestBody Car carJson) {
        LOGGER.debug("POST Request | carJson");
        carDAO.addCar(carJson);
        LOGGER.info("POST Request | Succesfully added Car to the list");
        return new ResponseEntity<>("Created car with ID: " + carJson.getId(), HttpStatus.OK);
    }

    /**
     * Method for editing an already existing car
     * @param carJson
     * @param id
     * @return ID of updated Car & HTTP: Ok  OR  incorrectParameterResponse
     */
    @ApiOperation(
            value = "Edit an existing Car",
            notes = "You can edit an existing car, if you write a car json into the Body, all empty parameters should not change",
            response = Car.class
    )
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

    /**
     *
     * @param id
     * @return ID of deleted Car & HTTP: no content
     */
    @ApiOperation(
            value = "Delete Car from the list",
            notes = "With this method it is possible to delete a car from the list, if you provide its ID",
            response = Car.class
    )
    @DeleteMapping(value = "/car/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable(value = "id") int id) {
        if (carDAO.isInvalidID(id)) {
            LOGGER.error("DELETE Request | No car found with ID: " + id);
            return incorrectParameterResponse();
        }
        else if (carDAO.getAllCars().contains(id)) {

        }
        carDAO.deleteCar(id);
        LOGGER.info("DELETE Request | Succesfully deleted car: " + id);
        return new ResponseEntity<>("Deleted: " + id, HttpStatus.NO_CONTENT);
    }


    @ApiOperation(
            value = "Delete All Cars from the list",
            notes = "With this method it is possible to delete every car from the list",
            response = Car.class
    )
    @DeleteMapping(value = "/reset")
    public ResponseEntity<?> resetAllCars() {
        carDAO.clearAllCars();
        LOGGER.info("DELETE Request | Succesfully deleted all cars");
        return new ResponseEntity<>("Empty Database", HttpStatus.NO_CONTENT);
    }


    /**
     *
     * @return "This ID does not exist" % HTTP: Bad Request
     */
    public static ResponseEntity<String> incorrectParameterResponse() {
        return new ResponseEntity<String>("This ID does not exist", HttpStatus.BAD_REQUEST);
    }

    /**
     *
     * @return HTTP: Bad Request
     */
    public static ResponseEntity<Car> incorrectParameterResponse2() {
        return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
    }


}
