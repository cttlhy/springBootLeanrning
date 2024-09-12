package com.mini.singleton;

public class InnerSingleton {

    private InnerSingleton() {
    }

    private static class SingletonHolder{
        private static final InnerSingleton instance = new InnerSingleton();
    }

    public static InnerSingleton getInstance(){
        return SingletonHolder.instance;
    }
}
