package com.mini.factoryMethod;

public class Car implements Vehicle
{
    @Override
    public void drive() {
        System.out.println("小汽车行驶...");
    }
}
