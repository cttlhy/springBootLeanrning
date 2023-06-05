package com.mini.beans;

public interface SingletonBeanRegistry {

        Object getSingleton(String beanName);

        void registerSingleton(String beanName, Object singletonObject);

        boolean containsSingleton(String beanName);

        String[] getSingletonNames();
}
