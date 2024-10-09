package com.mini.chainofResponsibility;

public class TestChain {
    public static void main(String[] args) {
        Handler handler1 = new LevelOneHandler();
        Handler handler2 = new LevelTwoHandler();
        Handler handler3 = new LevelThreeHandler();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);

        handler1.handleRequest(1);
        handler1.handleRequest(2);
        handler1.handleRequest(3);
    }
}
