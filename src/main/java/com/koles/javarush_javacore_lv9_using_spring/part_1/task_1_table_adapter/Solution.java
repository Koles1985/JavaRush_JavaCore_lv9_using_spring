
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_1_table_adapter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("tableAdapter")
@Scope("prototype")
public class Solution {
    public Solution(){
        System.out.println("Table Adapter created!");
    }
    
}
