package com.mini.adapter;

public class Adapter implements ITarget{
    protected IAdaptee adaptee;

    public Adapter(IAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void process() {
        int ab = adaptee.bar();
        adaptee.foo(11);
    }
}
