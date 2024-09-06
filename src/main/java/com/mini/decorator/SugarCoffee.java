package com.mini.decorator;

public class SugarCoffee extends CoffeDecorator{
    public SugarCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription(){
        return coffee.getDescription()+",sugar";
    }

    @Override
    public double cost() {
        return coffee.cost()+2.0;
    }
}
