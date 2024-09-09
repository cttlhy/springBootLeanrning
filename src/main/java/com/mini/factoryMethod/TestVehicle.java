package com.mini.factoryMethod;

public class TestVehicle {

    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new CarFactory();
        vehicleFactory.driveVehicle();

        VehicleFactory vehicleFactory1 = new BusFactory();
        vehicleFactory1.driveVehicle();
    }
}
