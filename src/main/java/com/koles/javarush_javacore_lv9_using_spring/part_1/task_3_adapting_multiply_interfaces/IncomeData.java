/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_3_adapting_multiply_interfaces;

/**
 *
 * @author User
 */
public interface IncomeData {
    default String getCountryCode(){
        return "RUS";
    }
    String getCompany();
    String getContactFirstName();
    String getContactLastName();
    int getCountryPhoneCode();
    int getPhoneNumber();
}
