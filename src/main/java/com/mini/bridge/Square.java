package com.mini.bridge;

public class Square extends Shape{

    public Square(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("在画方形：");
        color.applyColor();
    }
}
