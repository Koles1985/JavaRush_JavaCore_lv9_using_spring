/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_3.task_5;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import javax.imageio.stream.FileImageOutputStream;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("duplicateText")
@Scope("prototype")
public class Solution implements Tasks{
    
    private String fileName = "C:\\Users\\User\\Desktop\\";
    private ByteArrayOutputStream byteArrayOutputStream;
    private PrintStream baseOut;
    private PrintStream myOut;
    public Solution() {
        
        this.baseOut = System.out;
        this.byteArrayOutputStream = new ByteArrayOutputStream();
        this.myOut = new PrintStream(byteArrayOutputStream);
        setFileName();
        System.setOut(myOut);
        new TestString().printSomething();
        String result = byteArrayOutputStream.toString();
        writeToFile(fileName);
        System.setOut(baseOut);
        System.out.println(result);
        
    }
    
    
    /**
     * Получаем имя файла с консоли
     * по умолчанию путь к рабочему столу
     * нужно написать только имя файла на рабочем столе
     */
    private void setFileName(){
        BufferedReader reader = null;
        
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName += reader.readLine();
        }catch(IOException e){
            //NOT
        }finally{
            try{
                if(reader != null){
                    reader.close();
                }
            }catch (IOException e) {
                //Not
            }
        
        }
    }
    
    /**
     * Записываем данные в файл
     * @param fileName имя файла куда записывать данные
     */
    private void writeToFile(String fileName) {
        try(FileOutputStream output = new FileOutputStream(fileName)){
            byteArrayOutputStream.writeTo(output);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    private class TestString {
        private void printSomething(){
            System.out.println("This is a text for testing programm!");
        }
    }
}
