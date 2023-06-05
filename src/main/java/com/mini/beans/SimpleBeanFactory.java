package com.mini.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory, BeanDefinitionRegistry {

    private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    private List<String> beanDefinitions = new ArrayList<>();

    public SimpleBeanFactory() {
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName,beanDefinition);
        this.beanDefinitions.add(beanName);
        if (!beanDefinition.isLazyInit()){
            try {
                this.getBean(beanName);
            } catch (BeansException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeBeanDefinition(String beanName){
        this.beanDefinitionMap.remove(beanName);
        this.beanDefinitions.remove(beanName);
        this.removeSingleton(beanName);
    }

    public BeanDefinition getBeanDefinition(String beanName){
        return this.beanDefinitionMap.get(beanName);
    }

    public boolean containsBeanDefinition(String beanName){
        return this.beanDefinitionMap.containsKey(beanName);
    }

    public boolean isSingleton(String beanName){
        return this.beanDefinitionMap.get(beanName).isSingleton();
    }

    public boolean isPrototype(String beanName){
        return this.beanDefinitionMap.get(beanName).isPrototype();
    }

    public Class<?> getType(String beanName){
        return this.beanDefinitionMap.get(beanName).getClass();
    }


    @Override
    public Object getBean(String name) throws BeansException {
        Object singleton = singletons.get(name);
        if (singleton == null) {
            Object singleton1 = this.getSingleton(name);
            if (singleton1 == null) {
                BeanDefinition beanDefinition = beanDefinitionMap.get(name);
                if (beanDefinition == null) {
                    throw new BeansException("No bean named '" + name + "' is defined");
                }
                try {
                    singleton = Class.forName(beanDefinition.getClassName()).newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new BeansException("No bean named '" + name + "' is defined");
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                this.registerSingleton(name,singleton);
            }
        }
        return singleton;
    }

    public void registerBeanDefinition(BeanDefinition beanDefinition) {
        registerSingleton(); }

    @Override
    public boolean containsBean(String name) {
        return containsSingleton(name);
    }

}


