/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_3.task_3;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("outputOnlyNumbers")
@Scope("prototype")
public class Solution implements Tasks {
    
    
    private final PrintStream baseOut;
    private PrintStream newOut;
    private ByteArrayOutputStream byteArrayOutput;
    public Solution() {
        
        this.baseOut = System.out;
        this.byteArrayOutput = new ByteArrayOutputStream();
        this.newOut = new PrintStream(byteArrayOutput);
        
        System.setOut(newOut);
        new TestString().printSomething();
        String result = putOnlyNumbers(byteArrayOutput.toString());
        
        System.setOut(baseOut);
        System.out.println(result);
        
    }
    
    private String putOnlyNumbers(String initialLine){
        return initialLine.replaceAll("\\D", "");
    }
    
    
    public class TestString {
        public void printSomething(){
            System.out.println("it'1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
