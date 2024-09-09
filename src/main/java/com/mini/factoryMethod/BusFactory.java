package com.mini.factoryMethod;

public class BusFactory extends VehicleFactory
{
    @Override
    public Vehicle createVehicle() {
        return new Bus();
    }
}
