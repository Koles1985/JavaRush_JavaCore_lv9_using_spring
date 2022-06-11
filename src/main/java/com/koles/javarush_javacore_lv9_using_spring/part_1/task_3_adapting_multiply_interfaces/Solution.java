package com.koles.javarush_javacore_lv9_using_spring.part_1.task_3_adapting_multiply_interfaces;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("adaptingMultiplyInterfaces")
@Scope("prototype")
public class Solution implements Tasks {
    
    public static Map<String, String> countries = new HashMap<>();
    static{
        countries.put("UA", "Украина");
        countries.put("RUS", "Россия");
        countries.put("CA", "Канада");
    }
    
    private IncomeDataAdapter incomeDataAdapter;
    public Solution(){
        System.out.println("Adapting multiply interfaces created!");
        IncomeData inData = new IncomeData(){
            @Override
            public String getCountryCode() {
                return "RUS";
            }

            @Override
            public String getCompany() {
                return "Koles Interteimant";
            }

            @Override
            public String getContactFirstName() {
                return "Nikolay";
            }

            @Override
            public String getContactLastName() {
                return "Orekhov";
            }

            @Override
            public int getCountryPhoneCode() {
                return 7;
            }

            @Override
            public int getPhoneNumber() {
                return 1234567890;
            }
            
        };
        
        incomeDataAdapter = new IncomeDataAdapter(inData);
        
        System.out.println(incomeDataAdapter.getCompanyName());
        System.out.println(incomeDataAdapter.getPhoneNumber());
        System.out.println(incomeDataAdapter.getCountryName());
        System.out.println(incomeDataAdapter.getName());
        
    }
}
