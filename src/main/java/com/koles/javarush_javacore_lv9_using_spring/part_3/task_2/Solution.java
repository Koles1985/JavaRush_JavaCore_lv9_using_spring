/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_3.task_2;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("readerWrap2")
@Scope("prototype")
public class Solution implements Tasks {
    private PrintStream baseOut;
    private PrintStream newOut;
    private ByteArrayOutputStream byteArrayOutput;
    public Solution() {
        baseOut = System.out;
        byteArrayOutput = new ByteArrayOutputStream();
        newOut = new PrintStream(byteArrayOutput);
        
        System.setOut(newOut);
        
        new TestString().printSomeThing();
        
        String result = byteArrayOutput.toString().replaceAll("te", 
                "??");
        
        System.setOut(baseOut);
        System.out.println(result);
    }
    
    public class TestString {
        public void printSomeThing(){
            System.out.println("This is a text for test string from TestString class, "
                    + "for test self out");
        }
    }
}
