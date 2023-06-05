package com.mini;

import com.mini.beans.BeansException;
import com.mini.context.ClassPathXmlApplicationContext;
import com.mini.test.AService;

public class Test1 {

    public static void main(String[] args) throws BeansException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        AService aService = (AService) context.getBean("aService");
        aService.sayHello();
    }
}
