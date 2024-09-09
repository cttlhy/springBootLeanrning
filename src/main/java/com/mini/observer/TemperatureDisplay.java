package com.mini.observer;

public class TemperatureDisplay implements Observer{
    public float temperature;

    @Override
    public void update(float value) {
        this.temperature = value;
        display();
    }

    private void display() {
        System.out.println("当前温度："+ temperature);
    }
}
