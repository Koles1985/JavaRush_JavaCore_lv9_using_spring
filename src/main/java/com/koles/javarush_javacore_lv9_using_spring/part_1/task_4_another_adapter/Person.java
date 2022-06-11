/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_4_another_adapter;

import java.util.Date;

/**
 *
 * @author User
 */
public class Person {
    private String firstName;
    private String midleName;
    private String lastName;
    private Date birthDate;
    
    public Person(String lastName, String firstName, String midleName, 
            Date birthDate){
        this.firstName = firstName;
        this.midleName = midleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    
    
    @Override
    public String toString(){
        String personString = String.format("%s %s %s %s", lastName,
                firstName, midleName, birthDate.toString());
        
        return personString;
    }
    
}
