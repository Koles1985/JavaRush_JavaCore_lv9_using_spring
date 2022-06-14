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
        
        Tasks solution = context.getBean("punctuation", 
                Tasks.class);
        
        
        context.close();
    }
}
