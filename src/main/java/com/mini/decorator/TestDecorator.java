package com.mini.decorator;

public class TestDecorator {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.printf("订购一个简单的coffee：",coffee.getDescription(),coffee.cost());

        coffee = new SugarCoffee(coffee);
        System.out.println(coffee.getDescription()+coffee.cost());

        // 为咖啡再加糖
        coffee = new MilkCoffee(coffee);
        System.out.println(coffee.getDescription() + " $ " + coffee.cost());
    }
}
