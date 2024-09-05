package com.mini.observer;

public class TestObserver {

    public static void main(String[] args) {
        WeatherStation subject = new WeatherStation();

        TemperatureDisplay observer1 = new TemperatureDisplay();
        TemperatureDisplay observer2 = new TemperatureDisplay();

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.setTemporeature(10);

        subject.removeObserver(observer1);

        subject.setTemporeature(20);
    }
}
