package com.koles.javarush_javacore_lv9_using_spring.part_4.task_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class Solution {

    private String fileName = "/home/user/Documents/";
    private List<String> stringList;
    private Map<String, Double> listOfEmployeesAndTheirSalaries;
    private Double maxSalary;

    public Solution(String[] arg) {
        if(arg.length < 1){
            return;
        }else {
            fileName += arg[0];
        }

        stringList = readFile(fileName);
        listOfEmployeesAndTheirSalaries = countingSalaries(stringList);
        maxSalary = findMaxSalary(listOfEmployeesAndTheirSalaries);
        nameOutputBySalary(listOfEmployeesAndTheirSalaries, maxSalary);
    }

    /**
     * читает файл и записывает данные в ArrayList
     * @param fileName - имя файла для чтения
     * возвращает список строк файла
     */
    private List<String> readFile(String fileName) {
        List<String> stringList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName,
                Charset.forName("UTF-8")))){

            while(reader.ready()){
                stringList.add(reader.readLine());
            }

        }catch(IOException e) {
            e.printStackTrace();
        }

        return stringList;
    }


    /**
     * разбивает строки на массивы строк
     * считывает имена и зарплаты
     * заносит в список Map имена и соответствующие зарплаты
     * @param list - список строк файла
     * @return отсортированый Map с именами и зарплатами
     */
    private Map<String, Double> countingSalaries(List<String> list) {
        Map<String, Double> listOfEmployeesAndTheirSalaries = new TreeMap<>();

        for(String line : list){
            String[] split = line.trim().split(" ");
            double salary = 0;
            String name = null;

            for(int i = 0; i < split.length; i++){
                try{
                    salary = Double.parseDouble(split[i]);
                }catch (NumberFormatException e) {
                    name = split[i];
                }
            }

            if(listOfEmployeesAndTheirSalaries.containsKey(name)){
                listOfEmployeesAndTheirSalaries.put(name,
                        Double.sum(listOfEmployeesAndTheirSalaries.get(name), salary));
            }else {
                listOfEmployeesAndTheirSalaries.put(name, salary);
            }
        }

        return listOfEmployeesAndTheirSalaries;
    }

    /**
     * ищет максимальное значение double
     * @param map - где искать
     * @return - максимально значение
     */
    private Double findMaxSalary(Map<String, Double> map) {
        double temp = 0;
        String name = null;
        for(String key : map.keySet()) {
               temp = Double.max(map.get(key), temp);
        }

        return temp;
    }

    /**
     * ищет key по параметру salary
     * добавляет key в treeset
     * выводит на экран все совпадения в алфавитном порядке
     * @param map - где искать
     * @param salary - значение поиска
     */
    private void nameOutputBySalary(Map<String, Double> map, Double salary) {
        Set<String> names = new TreeSet<>();
        for(Map.Entry<String, Double> entry : map.entrySet()) {
            if(entry.getValue().equals(salary)) {
                names.add(entry.getKey());
            }
        }

        for(String name : names) {
            System.out.println(name);
        }
    }
}
