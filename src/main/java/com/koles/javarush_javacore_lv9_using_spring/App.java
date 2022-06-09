package com.koles.javarush_javacore_lv9_using_spring;

import com.koles.javarush_javacore_lv9_using_spring.part_1.task_1_table_adapter.Solution;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ){
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext.xml");
        
        Solution solution = context.getBean("tableAdapter", Solution.class);
    }
    
}
