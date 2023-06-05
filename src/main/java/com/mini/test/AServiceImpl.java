package com.mini.test;

public class AServiceImpl implements AService {

    public void setProperty1(String property1) {
        this.property1 = property1;
    }

    private String property1;

    public void sayHello() {
        System.out.println("a service 1 say hello");
    } 
} 