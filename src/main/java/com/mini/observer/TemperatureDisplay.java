package com.mini.observer;

public class TemperatureDisplay implements Observer{
    public float temporature;

    @Override
    public void update(float value) {
        this.temporature = value;
        display();
    }

    private void display() {
        System.out.println("当前温度："+temporature);
    }
}
