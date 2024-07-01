package edu.sdccd.cisc191.template;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleRequestTest {
    private VehicleRequest vehicleRequest;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        vehicleRequest = new VehicleRequest();
    }

    @org.junit.jupiter.api.Test
    void testGetAndSetYear() {
        vehicleRequest.setYear(2024);
        assertEquals(2024, vehicleRequest.getYear());
    }

    @org.junit.jupiter.api.Test
    void testGetAndSetMake() {
        vehicleRequest.setMake("Tesla");
        assertEquals("Tesla", vehicleRequest.getMake());
    }

    @org.junit.jupiter.api.Test
    void testGetAndSetModel() {
        vehicleRequest.setModel("3");
        assertEquals("3", vehicleRequest.getModel());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        vehicleRequest.setYear(2024);
        vehicleRequest.setMake("Tesla");
        vehicleRequest.setModel("3");
        assertEquals("VehicleRequest{year=2024, make='Tesla', model='3'}", vehicleRequest.toString());
    }
}
