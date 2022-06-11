/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_5_fixing_adapter;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("fixingAdapter")
@Scope("prototype")
public class Solution implements Tasks {
    
    public static Map<String, String> countries = new HashMap<>();
    static{
        countries.put("RUS", "Russia");
        countries.put("CHI", "China");
        countries.put("BR", "Belarus");
        
    }
    
    private DataAdapter dataAdapter;
    
    public Solution(){
        Customer customer = new Customer(){
            @Override
            public String getCompanyName() {
                return "Kolyabich enterprised";
            }

            @Override
            public String getCountryName() {
                return "Russia";
            }  
        };
        
        Contact contact = new Contact(){
            @Override
            public String getName() {
                return "Orekhov, Nikolay";
            }

            @Override
            public String getPhoneNumber() {
                return "+7(123)456-78-90";
            }
            
        };
        
        this.dataAdapter = new DataAdapter(customer, contact);
        
        System.out.println(this.dataAdapter.getCompany());
        System.out.println(this.dataAdapter.getContactFirstName());
        System.out.println(this.dataAdapter.getContactLastName());
        System.out.println(this.dataAdapter.getCountryCode());
        System.out.println(this.dataAdapter.getDialString());
        
    }
    
}
