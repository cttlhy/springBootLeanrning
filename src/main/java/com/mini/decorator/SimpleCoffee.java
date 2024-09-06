package com.mini.decorator;

public class SimpleCoffee implements  Coffee{
    @Override
    public String getDescription() {
        return "这个是SimpleCoffee";
    }

    @Override
    public double cost() {
        return 10;
    }
}
