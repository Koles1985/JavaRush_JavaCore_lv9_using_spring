package com.koles.javarush_javacore_lv9_using_spring.part_1.task_3_adapting_multiply_interfaces;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("adaptingMultiplyInterfaces")
@Scope("prototype")
public class Solution implements Tasks {
    
    public static Map<String, String> countries = new HashMap<>();
    static{
        countries.put("UA", "Украина");
        countries.put("RUS", "Россия");
        countries.put("CA", "Канада");
    }
    public Solution(){
        System.out.println("Adapting multiply interfaces created!");
        
    }
}
