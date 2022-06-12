/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring;

import com.koles.javarush_javacore_lv9_using_spring.config_classes.AnotationSpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author User
 */
public class App2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(
                        AnotationSpringConfig.class);
        
        Tasks solution = context.getBean("countingWord", 
                Tasks.class);
        
        
        context.close();
    }
}
