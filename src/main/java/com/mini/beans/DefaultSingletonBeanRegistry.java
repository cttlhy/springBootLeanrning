package com.mini.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    protected List<String> beanNames = new ArrayList<>();

    protected Map<String,Object> singletons = new ConcurrentHashMap<>(256);

    protected Map<String, Set<String>> dependentBeanMap = new ConcurrentHashMap<>(64);

    protected Map<String, Set<String>> dependenciesForBeanMap = new ConcurrentHashMap<>(64);

    public void registerSingleton(String beanName,Object singletonObject){
        synchronized (this.singletons){
            singletons.put(beanName,singletonObject);
            beanNames.add(beanName);
        }
    }

    @Override
    public Object getSingleton(String beanName) {
        return this.singletons.get(beanName);
    }

    @Override
    public boolean containsSingleton(String beanName) {
        return this.singletons.containsKey(beanName);
    }

    @Override
    public String[] getSingletonNames() {
        return (String[])this.beanNames.toArray();
    }

    protected void removeSingleton(String beanName){
        synchronized (this.singletons){
            this.singletons.remove(beanName);
            this.beanNames.remove(beanName);
        }
    }

    protected void registerDependentBean(String beanName,String dependentBeanName){

    }

    protected boolean hasDependentBean(String beanName){
        return false;
    }

    protected String[] getDependentBeans(String beanName){
        return null;
    }

    protected String[] getDependenciesForBean(String beanName){
        return null;
    }


}
