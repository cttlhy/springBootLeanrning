package com.mini.command;

public class TestCommand {

    public static void main(String[] args) {
        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl control = new RemoteControl();
        control.setCommand(lightOff);
        control.PressButton();

        control.setCommand(lightOn);
        control.PressButton();

    }
}
