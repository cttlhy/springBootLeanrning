package com.mini.adapter;

public class TestAdapter {
    public static void main(String[] args) {
        IAdaptee old = new OldClass();

        ITarget newl = new Adapter(old);
        newl.process();
    }
}
