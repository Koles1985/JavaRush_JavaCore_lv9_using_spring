package com.koles.javarush_javacore_lv9_using_spring.part_2.task_3_select_numbers;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("selectNumbers")
@Scope("prototype")
public class Solution implements Tasks {
    private String firstFile = "C:\\Users\\User\\Desktop\\";
    private String secondFile = "C:\\Users\\User\\Desktop\\";
    public Solution() {
        readDataFromConsole();
        getInteger();
    }
    
    private void readDataFromConsole(){
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            
            firstFile += reader.readLine();
            secondFile += reader.readLine();
        }catch(IOException e){
            
        }finally{
            try{
                if(reader != null)
                    reader.close();
            }catch(IOException e){
                
            }
        }
    }

    private void getInteger() {
        try(BufferedReader reader = new BufferedReader(
                new FileReader(firstFile));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(secondFile))) {
            
            while(reader.ready()){
                
                String[] words = reader.readLine().split(" ");
                for(int i = 0; i < words.length; i++){
                    try{
                        int j = Integer.parseInt(words[i]);
                        writer.write(" " + j);
                    }catch(NumberFormatException e){
                        
                    }
                }
                writer.write("\n");
            }
            
        }catch(IOException e){
            
        }
        
    }
}
