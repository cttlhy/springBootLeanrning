package com.mini.command;

public class RemoteControl {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void PressButton(){
        if (command != null)
        {
            command.excute();
        }
    }
}
