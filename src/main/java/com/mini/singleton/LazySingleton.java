package com.mini.singleton;

public class LazySingleton {

    public static LazySingleton singleton;

    private LazySingleton(){}

    public static synchronized LazySingleton getSingleton(){
        if (singleton == null){
            synchronized (singleton){
                if (singleton == null){
                    return new LazySingleton();
                }
            }
        }
        return singleton;
    }

}
