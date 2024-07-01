package edu.sdccd.cisc191.template;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class VehicleResponseTest {

    private VehicleResponse vehicleResponse;
    private VehicleRequest vehicleRequest;

    @BeforeEach
    void setUp() {
        vehicleRequest = new VehicleRequest(2023, "Tesla", "Model S");
        vehicleResponse = new VehicleResponse(vehicleRequest, 23000, 58000, 5, 4, new String[]{"Option1", "Option2"});
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals(vehicleRequest, vehicleResponse.getRequest());
        assertEquals(23000, vehicleResponse.getMilesOnVehicle());
        assertEquals(58000, vehicleResponse.getPrice());
        assertEquals(5, vehicleResponse.getNumberOfSeats());
        assertEquals(4, vehicleResponse.getNumberOfDoors());
        assertArrayEquals(new String[]{"Option1", "Option2"}, vehicleResponse.getOptions());
    }

    @Test
    void testSetters() {
        vehicleResponse.setRequest(new VehicleRequest(2022, "Ford", "F-150"));
        vehicleResponse.setMilesOnVehicle(25000);
        vehicleResponse.setPrice(60000);
        vehicleResponse.setNumberOfSeats(6);
        vehicleResponse.setNumberOfDoors(2);
        vehicleResponse.setOptions(new String[]{"Option3", "Option4"});

        assertEquals(2022, vehicleResponse.getRequest().getYear());
        assertEquals("Ford", vehicleResponse.getRequest().getMake());
        assertEquals("F-150", vehicleResponse.getRequest().getModel());
        assertEquals(25000, vehicleResponse.getMilesOnVehicle());
        assertEquals(60000, vehicleResponse.getPrice());
        assertEquals(6, vehicleResponse.getNumberOfSeats());
        assertEquals(2, vehicleResponse.getNumberOfDoors());
        assertArrayEquals(new String[]{"Option3", "Option4"}, vehicleResponse.getOptions());
    }

    @Test
    void testToString() {
        String expectedString = "VehicleResponse{" +
                "request=VehicleRequest{year=2023, make=Tesla, model=Model S}, " +
                "milesOnVehicle=23000, " +
                "price=58000, " +
                "numberOfSeats=5, " +
                "numberOfDoors=4, " +
                "options=[Option1, Option2]" +
                "}";
        assertEquals(expectedString, vehicleResponse.toString());
    }

    @Test
    void testJSONSerializationDeserialization() {
        try {
            String json = VehicleResponse.toJSON(vehicleResponse);
            VehicleResponse deserialized = VehicleResponse.fromJSON(json);
            assertEquals(vehicleResponse.getRequest().getYear(), deserialized.getRequest().getYear());
            assertEquals(vehicleResponse.getMilesOnVehicle(), deserialized.getMilesOnVehicle());
            assertEquals(vehicleResponse.getPrice(), deserialized.getPrice());
            assertEquals(vehicleResponse.getNumberOfSeats(), deserialized.getNumberOfSeats());
            assertEquals(vehicleResponse.getNumberOfDoors(), deserialized.getNumberOfDoors());
            assertArrayEquals(vehicleResponse.getOptions(), deserialized.getOptions());
        } catch (Exception e) {
            fail("Exception thrown during JSON serialization/deserialization: " + e.getMessage());
        }
    }
}
