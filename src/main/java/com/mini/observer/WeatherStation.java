package com.mini.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{
    public float temporeature;
    public List<Observer> observers;

    public WeatherStation() {
        observers = new ArrayList<>();  // 初始化观察者列表
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(
                observer -> {
                    observer.update(temporeature);
                }
        );
    }

    public void setTemporeature(float temporeature) {
        this.temporeature = temporeature;
        notifyObserver();
    }
}
