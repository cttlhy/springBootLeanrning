package com.mini.adapter;

public class OldClass implements IAdaptee{
    @Override
    public void foo(int data) {
        System.out.println("this is old foo");
    }

    @Override
    public int bar() {
        return 10;
    }
}
