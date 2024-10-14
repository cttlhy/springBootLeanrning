package com.mini.running;

public class Test {
    public static void main(String[] args) {
        ParentClass parentClass = new ChildClass();

        SingleDispatchClass dispatchClass = new SingleDispatchClass();
        dispatchClass.polymorphismFunction(parentClass);
        dispatchClass.overLoadFunction(parentClass);
    }
}
