package com.mini.running;

public class SingleDispatchClass {
    public void polymorphismFunction(ParentClass p){
       p.f();
    }

    public void overLoadFunction(ParentClass p){
        p.f();
    }

    public void overLoadFunction(ChildClass c){
        c.f();
    }
}
