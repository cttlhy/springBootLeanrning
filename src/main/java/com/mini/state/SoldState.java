package com.mini.state;

public class SoldState implements IState {
    @Override
    public void insertCoin() {
        System.out.println("请稍后，正在出货");
    }

    @Override
    public void ejectCoin() {
        System.out.println("无法退还，正在出货");
    }

    @Override
    public void pressButton() {
        System.out.println("正在出货，稍等");
    }

    @Override
    public void dispense() {

    }
}
