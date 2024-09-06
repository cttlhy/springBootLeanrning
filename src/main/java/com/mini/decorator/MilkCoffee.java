package com.mini.decorator;

public class MilkCoffee extends CoffeDecorator{

    public MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription(){
        return coffee.getDescription()+",milk";
    }

    @Override
    public double cost() {
        return coffee.cost()+1.0;
    }
}
