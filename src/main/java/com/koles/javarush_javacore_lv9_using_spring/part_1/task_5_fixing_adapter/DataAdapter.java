/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_5_fixing_adapter;

import java.util.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("dataAdapter")
@Scope("prototype")
public class DataAdapter implements RowItem {
    
    private Customer customer;
    private Contact contact;
    
    public DataAdapter(){
        System.out.println("Adapter created");
    }
    
    public DataAdapter(Customer customer, Contact contact){
        this.customer = customer;
        this.contact = contact;
    }
    @Override
    public String getCountryCode() {
        String countryName = customer.getCountryName();
        Map<String, String> map = Solution.countries;
        String result = null;
        if(!map.containsValue(countryName))
            return null;
            for(Map.Entry<String, String> entryes : map.entrySet()){
                if(entryes.getValue().equals(countryName)){
                     result = entryes.getKey();
                     return result;
                }
                
            }
        
        return result;
    }

    @Override
    public String getCompany() {
        return customer.getCompanyName();
    }

    @Override
    public String getContactFirstName() {
        String[] name = contact.getName().split(", ");
        return name[name.length - 1];
    }

    @Override
    public String getContactLastName() {
        String fullName = contact.getName();
        int len = fullName.indexOf(", ");
        String lastName = fullName.substring(0, len);
        return lastName;
    }

    @Override
    public String getDialString() {
        String phone = contact.getPhoneNumber();
        String dial = String.format("calltO:// %s%s%s%s%s", 
                phone.substring(0, 2),//+7(
                phone.substring(3, 6),//000)
                phone.substring(7, 10),//000-
                phone.substring(11, 13),//00-
                phone.substring(14, 16));//00
        return dial;
    }
     
}
