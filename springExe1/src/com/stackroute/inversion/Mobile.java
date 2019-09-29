package com.stackroute.inversion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("config loaded");
        Sim sim = context.getBean("sim",Sim.class);
        sim.call();
        sim.mobiledata(); // can use either airtel or vodaphone by implementing in .xml file without changing the source code
    }
}
