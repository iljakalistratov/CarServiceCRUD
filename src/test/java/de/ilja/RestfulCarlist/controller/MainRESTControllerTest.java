package de.ilja.RestfulCarlist.controller;

import de.ilja.RestfulCarlist.dao.CarDAO;
import de.ilja.RestfulCarlist.model.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class MainRESTControllerTest {

//    @Mock
    private CarDAO carDAO = Mockito.mock(CarDAO.class);
    private MainRESTController mainRESTController = new MainRESTController(carDAO);
//    @Mock
    private static Car car = Mockito.mock(Car.class);

    @BeforeAll
    public static void setUp() {
        Mockito.when(car.getId()).thenReturn(753);
    }



    @Test
    void getCar_returnsOKIfObjectPresent() {


        Mockito.when(carDAO.isInvalidID(Mockito.anyInt())).thenReturn(false);
        ResponseEntity<Car> response = mainRESTController.readSingleAutomobile(car.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void testGetCar() {
    }

    @Test
    void addCar() {

        Mockito.when(carDAO.addCar(Mockito.any(Car.class))).thenReturn(car);
        assertEquals(HttpStatus.OK, mainRESTController.createCar(car).getStatusCode());

    }

    @Test
    void updateCar() {

        Mockito.when(carDAO.updateCar(Mockito.any(Car.class), Mockito.anyInt())).thenReturn(car);
        assertEquals(HttpStatus.OK, mainRESTController.updateCar(car, car.getId()).getStatusCode());

    }

    @Test
    void deleteCar() {

       assertEquals(HttpStatus.NO_CONTENT, mainRESTController.deleteCar(car.getId()).getStatusCode());

    }

    @Test
    void setMockIdCheckToFalse() {
        Mockito.when(carDAO.isInvalidID(Mockito.anyInt())).thenReturn(false);
    }
    void setMockIdToTrue() {
        Mockito.when(carDAO.isInvalidID(Mockito.anyInt())).thenReturn(true);
    }
}