package de.ilja.RestfulCarlist.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void generateId() {

        //Generate many objects to test if the counter works properly
        for (int i = 0; i <= 1000; i++ ) {
            Car testcar = new Car("test", "test", "0", "2000", "1.8 Benzin", "8");
            assertEquals(i + 1000, testcar.getId());
        }
    }
}