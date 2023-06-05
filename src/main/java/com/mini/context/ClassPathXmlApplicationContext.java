package com.mini.context;

import com.mini.beans.BeanFactory;
import com.mini.beans.BeansException;
import com.mini.beans.SimpleBeanFactory;
import com.mini.beans.XmlBeanDefinitionReader;
import com.mini.core.*;

public class ClassPathXmlApplicationContext implements BeanFactory,
        ApplicationEventPublisher {

    SimpleBeanFactory beanFactory;

    public ClassPathXmlApplicationContext(String path) {
        Resource resource = new ClassPathXmlResource(path);
        SimpleBeanFactory simpleBeanFactory = new SimpleBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(simpleBeanFactory);
        reader.loadBeanDefinitions(resource);
        this.beanFactory = simpleBeanFactory;
    }


    public Object getBean(String beanId) throws BeansException {
        return beanFactory.getBean(beanId);
    }


    public boolean containsBean(String beanName) {
        return beanFactory.containsBean(beanName);
    }

    @Override
    public boolean isSingleton(String name) {
        return false;
    }

    @Override
    public boolean isPrototype(String name) {
        return false;
    }

    @Override
    public Class<?> getType(String name){
        return null;
    }


    @Override
    public void publishEvent(ApplicationEvent event) {

    }
}
