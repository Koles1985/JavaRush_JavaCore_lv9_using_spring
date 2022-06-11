/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_1.task_3_adapting_multiply_interfaces;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("incomeDataAdapter")
@Scope("prototype")
public class IncomeDataAdapter implements Customer, Contact{
    
    private IncomeData incomeData;

    public IncomeDataAdapter(IncomeData incomeData) {
        this.incomeData = incomeData;
    }
    
    
    @Override
    public String getCompanyName() {
        return this.incomeData.getCompany();
    }

    @Override
    public String getCountryName() {
        String country = Solution.countries.get(
                this.incomeData.getCountryCode());
        return country;
    }

    @Override
    public String getName() {
        StringBuilder nameBuilder = new StringBuilder();
        nameBuilder.append(this.incomeData.getContactLastName());
        nameBuilder.append(", ");
        nameBuilder.append(this.incomeData.getContactFirstName());
        return nameBuilder.toString();
    }

    @Override
    public String getPhoneNumber() {
        String phoneNum = String.format("%d", 
                this.incomeData.getPhoneNumber());
        int phoneCode = this.incomeData.getCountryPhoneCode();
        
        String fullNumber = String.format("+%d(%s)%s - %s - %s",
                phoneCode, phoneNum.substring(0, 3),
                phoneNum.substring(3, 6), 
                phoneNum.substring(6, 8),
                phoneNum.substring(8, 10));
        return fullNumber;
    }
    
    
}
