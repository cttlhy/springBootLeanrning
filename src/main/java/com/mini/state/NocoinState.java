package com.mini.state;

public class NocoinState implements IState {

    @Override
    public void insertCoin() {
        System.out.println("插入一枚硬币");
    }

    @Override
    public void ejectCoin() {
        System.out.println("您还没有投入硬币");
    }

    @Override
    public void pressButton() {
        System.out.println("您按下了按钮，还没有投入硬币");
    }

    @Override
    public void dispense() {
        System.out.println("无法发放商品");
    }
}
