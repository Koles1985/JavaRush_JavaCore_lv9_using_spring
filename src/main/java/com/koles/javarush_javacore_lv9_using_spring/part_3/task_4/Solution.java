
package com.koles.javarush_javacore_lv9_using_spring.part_3.task_4;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("solvingAnExample")
@Scope("prototype")
public class Solution implements Tasks {
    
    private final PrintStream baseOut;
    private PrintStream newOut;
    private ByteArrayOutputStream byteArrayOutput;
    public Solution() {
        
        this.byteArrayOutput = new ByteArrayOutputStream();
        this.baseOut = System.out;
        this.newOut = new PrintStream(byteArrayOutput);
        
        System.setOut(newOut);
        
        new TestString().printSomething('*');
        
        String result = byteArrayOutput.toString();
        
        char operation = getAriphmeticalOperation(result);
        
        int[] numbers = getNumbersFromString(result);
        
        System.setOut(baseOut);
        
        System.out.println(operation);
        System.out.println(ariphmeticalOperation(numbers, operation));
        
        
        
        
        
    }
    
    private int ariphmeticalOperation(int[] num, char operation){
        int res = Integer.MIN_VALUE;
        switch(operation){
            case '+': 
                res = num[0] + num[1];
                break;
            case '-': 
                res = num[0] - num[1]; 
                break;
            case '/': 
                if(num[1] != 0)
                    res = num[0] / num[1];
                else res = -1;
                break;
            case '*' :
                res = num[0] * num[1];
                break;
                
        }
        return res;
    }
    
    
    private char getAriphmeticalOperation(String initialLine){
        String result = initialLine.replaceAll("\\d", "").trim();
        return result.charAt(0);
    }
    
    private int[] getNumbersFromString(String initialLine){
        String[] chars = initialLine.split(" ");
        int[] num = new int[2];
        for (int i = 0, j = 0; i < chars.length; i++) {
            try{
            
                num[j] = Integer.parseInt(chars[i].trim());
                j++;
            }catch(NumberFormatException e){
                //Not
            }
        }
        
        return num;
        
    }
    private class TestString {
        private void printSomething(char operation) {
            System.out.println("3 " + operation + " 6 = ");
        }
    }
    
}
