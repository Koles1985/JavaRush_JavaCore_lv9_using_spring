package com.koles.javarush_javacore_lv9_using_spring.part_4.task_11_contextual_advertising;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream stream = new ByteArrayOutputStream();
    private PrintStream mySystemOut = new PrintStream(stream);
    TestString testString = new TestString();
    public Solution() {
        System.setOut(mySystemOut);
        testString.printSomething();
        System.setOut(systemOut);
        printText();
    }

    private void printText(){
        String[] array = stream.toString().split("\n");
        for(int i = 0, j = 1; i < array.length; i++){
            System.out.println(array[i]);
            if(i == j){
                System.out.println("Koles genius");
                j += 2;
            }

        }
    }


}
