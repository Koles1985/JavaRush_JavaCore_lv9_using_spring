/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_3.task_1;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("readerWrap")
@Scope("prototype")
public class Solution implements Tasks {
    
    private final PrintStream SYS_OUT;
    private ByteArrayOutputStream byteArrayOutput;
    private PrintStream printStream;
    public Solution() {
        this.SYS_OUT = System.out;
        this.byteArrayOutput = new ByteArrayOutputStream();
        this.printStream = new PrintStream(byteArrayOutput);
        TestString testString = new TestString();
        System.setOut(printStream);
        testString.printSomething();
        String text = byteArrayOutput.toString();
        text = text.toUpperCase();
        System.setOut(SYS_OUT);
        System.out.println(text);
        
    }
    
    
    
    public class TestString{
        public void printSomething(){
            System.out.println("This is a text for testing!");
        }
    }
}
