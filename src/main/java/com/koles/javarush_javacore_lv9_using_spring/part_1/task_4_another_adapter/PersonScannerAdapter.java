/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_4_another_adapter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class PersonScannerAdapter implements PersonScanner {
    private Scanner fileScanner;
    public PersonScannerAdapter(Scanner fileScanner){
        this.fileScanner = fileScanner;
    }
    
    private int[] getIntFromStringArray(String[] array){
        int[] date = new int[3];
        for(int i = 0; i < array.length; i++){
            try{
                int j = Integer.parseInt(array[i]);
                if(j > 12 && j > 31){ //year
                    date[0] = j;
                }else if(j <= 12 && date[2] != 0){//month
                    date[1] = j;
                }else{ //day
                    date[2] = j;
                }
            }catch(NumberFormatException e){
                
            }
        }
        return date;
    }

    @Override
    public Person read() throws IOException {
        String readLine = this.fileScanner.nextLine();
        String[] data = readLine.split(" ");
        int[] date = getIntFromStringArray(data);
        Calendar calendar = new GregorianCalendar(date[0], date[1] - 1, date[2]);
        Date birthDate = calendar.getTime();
        Person person = new Person(data[0], data[1], data[2], birthDate);
        
        return person;
    }

    @Override
    public void close() throws IOException {
        this.fileScanner.close();
    }
    
    
}
