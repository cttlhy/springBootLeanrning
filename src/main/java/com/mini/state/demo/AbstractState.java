package com.mini.state.demo;

// AbstractState.java
public abstract class AbstractState implements IState {
    @Override
    public void obtainMushRoom() {
        // 默认不支持该操作
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override
    public void obtaincape() {
        // 默认不支持该操作
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override
    public void obtainFire() {
        // 默认不支持该操作
        throw new UnsupportedOperationException("Operation not supported.");
    }

    @Override
    public void meetMonster() {
        // 默认不支持该操作
        throw new UnsupportedOperationException("Operation not supported.");
    }
}
