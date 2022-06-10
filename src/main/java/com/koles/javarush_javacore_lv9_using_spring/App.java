package com.koles.javarush_javacore_lv9_using_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ){
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Tasks solution = context.getBean("adaptingMultiplyInterfaces", Tasks.class);
    }
    
}
