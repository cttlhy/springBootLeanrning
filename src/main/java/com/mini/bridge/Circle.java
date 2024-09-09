package com.mini.bridge;

public class Circle extends Shape{

    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("在画⚪：");
        color.applyColor();
    }
}
