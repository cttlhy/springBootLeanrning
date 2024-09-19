package com.mini.state;

public class HasCoinState implements IState {
    @Override
    public void insertCoin() {
        System.out.println("您已经投入硬币");
    }

    @Override
    public void ejectCoin() {
        System.out.println("退还硬币");
    }

    @Override
    public void pressButton() {
        System.out.println("按钮被按下，准备出货");
    }

    @Override
    public void dispense() {
        System.out.println("无法出货");
    }
}
