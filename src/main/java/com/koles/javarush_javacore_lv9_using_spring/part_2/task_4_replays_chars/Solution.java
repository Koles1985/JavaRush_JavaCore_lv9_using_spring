package com.koles.javarush_javacore_lv9_using_spring.part_2.task_4_replays_chars;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("replaceChar")
@Scope("prototype")
public class Solution implements Tasks {
    private String firstFile = "C:\\Users\\User\\Desktop\\";
    private String secondFile = "C:\\Users\\User\\Desktop\\";
    public Solution() {
        readDataFromConsole();
        replaceCharsToFile();
    }
    
    private void readDataFromConsole() {
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            firstFile += reader.readLine();
            secondFile += reader.readLine();
        }catch(IOException e){
            //NOT
        }finally{
            try{
                if(reader != null)
                    reader.close();
            }catch(IOException e){
                //NOT
            }
        }
    }
    
    private void replaceCharsToFile(){
        try(FileReader reader = new FileReader(firstFile, Charset.forName("UTF-8"));
            FileWriter writer = new FileWriter(secondFile)){
            
            while(reader.ready()){
                char symbol = (char)reader.read();
                if(symbol == '.')
                    symbol = '!';
                writer.write(symbol);
            }
            
        }catch(IOException e){
            //NOT
        }
    }
}
