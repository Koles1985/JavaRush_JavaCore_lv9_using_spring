/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_2.task_1_even_character;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("evenCharacter")
@Scope("prototype")
public class Solution implements Tasks {
    private String firstFile = "C:\\Users\\User\\Desktop\\";
    private String secondFile = "C:\\Users\\User\\Desktop\\";
    public Solution() {
        readConsole();
        writeEvenCharactersToSecondFileFromFirstFile(firstFile,
                secondFile);
    }
    
    private void readConsole(){
        try(Scanner scanner = new Scanner(System.in)){
            firstFile += scanner.nextLine();
            secondFile += scanner.nextLine();
        }
    }
    
    private void writeEvenCharactersToSecondFileFromFirstFile(
            String file, String secondFile){
        try(FileReader reader = new FileReader(file, 
                Charset.forName("UTF-8"));
            FileWriter writer = new FileWriter(secondFile)){
            
            while(reader.ready()){
                int character = reader.read();//получаем код символа
                if((character % 2) == 0){
                    System.out.printf("char %c = %d\n", (char)character,
                            character);
                    writer.write(character);
                }
            }
            
            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
