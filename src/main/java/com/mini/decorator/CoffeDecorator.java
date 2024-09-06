package com.mini.decorator;

public abstract class CoffeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription(){
       return coffee.getDescription();
    }

    @Override
    public double cost() {
        return coffee.cost();
    }
}
