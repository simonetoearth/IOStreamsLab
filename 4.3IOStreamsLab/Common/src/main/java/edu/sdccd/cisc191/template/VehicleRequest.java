package edu.sdccd.cisc191.template;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VehicleRequest {
    private int year;
    private String make;
    private String model;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public VehicleRequest() {
        // Default constructor
    }

    public VehicleRequest(int year, String make, String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public static String toJSON(VehicleRequest vehicleRequest) throws Exception {
        return objectMapper.writeValueAsString(vehicleRequest);
    }

    public static VehicleRequest fromJSON(String input) throws Exception {
        return objectMapper.readValue(input, VehicleRequest.class);
    }

    @Override
    public String toString() {
        return "year = " + year + " make = " + make + " model = " + model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
