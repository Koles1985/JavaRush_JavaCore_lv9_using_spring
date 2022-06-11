/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_4_another_adapter;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;

import java.io.IOException;
import java.util.Scanner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("anotherAdapter")
@Scope("prototype")
public class Solution implements Tasks {
    PersonScannerAdapter psa;
    public Solution(){
        
        psa = new PersonScannerAdapter(new Scanner(System.in));
        try{
            System.out.println(psa.read());
            psa.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
}
