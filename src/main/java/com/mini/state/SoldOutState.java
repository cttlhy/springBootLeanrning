package com.mini.state;

// SoldOutState.java
public class SoldOutState implements IState {
    
    @Override
    public void insertCoin() {
        System.out.println("商品已售罄，无法投入硬币。");
    }
    
    @Override
    public void ejectCoin() {
        System.out.println("您没有投入硬币。");
    }
    
    @Override
    public void pressButton() {
        System.out.println("商品已售罄。");
    }
    
    @Override
    public void dispense() {
        System.out.println("无法发放商品。");
    }
}