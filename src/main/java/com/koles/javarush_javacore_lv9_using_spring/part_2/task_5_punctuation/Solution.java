/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_2.task_5_punctuation;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("punctuation")
@Scope("prototype")
public class Solution implements Tasks {
    private String firstFile = "C:\\Users\\User\\Desktop\\";
    private String secondFile = "C:\\Users\\User\\Desktop\\";
    public Solution() {
        readStringFromConsole();
        List<String> dataList = getDataFromFileAndWriteThemToList();
        removeAllPunctuationMarksAndWriteToFile(dataList);
    }
    
    private void readStringFromConsole() {
        try(BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in))) {
            firstFile += reader.readLine();
            secondFile += reader.readLine();
        }catch(IOException e) {
            //NOT
        }
    }
    
    private List<String> getDataFromFileAndWriteThemToList(){
        List<String> fileDataList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(
                new FileReader(firstFile, Charset.forName("UTF-8")))) {
            
            while(reader.ready())
                fileDataList.add(reader.readLine());
            
        }catch(IOException e) {
            //NOT
        }
        
        return fileDataList;
    }
    
    private void removeAllPunctuationMarksAndWriteToFile(
            List<String> dataList) {
        try(BufferedWriter writer = new BufferedWriter(
                new FileWriter(secondFile, Charset.forName("UTF-8")))) {
            
            for(String line : dataList){
                writer.write(line.replaceAll("\\pP", ""));
            }
        }catch(IOException e) {
            //NOT
        }
    }
}
