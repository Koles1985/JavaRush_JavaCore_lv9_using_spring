package com.koles.javarush_javacore_lv9_using_spring.part_4.task_4;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
Считаем зарплаты
 */
public class Solution {

    private String fileName = "C:\\Users\\User\\Desktop\\";
    private List<String> fileLines = new ArrayList<>();
    private Map<String, Double> result = new TreeMap<>();
    public Solution(String[] arg) {
        if(arg.length < 1){
            return;
        }

        setFileName(arg[0]);
        readFile(fileName);
        fillMap(fileLines);
        outOfConsole(result);
    }

    /**
     * получаем имя файла и дописываем его к уже существующему пути
     * @param fileName имя файла
     */
    private void setFileName(String fileName) {
        this.fileName += fileName;
    }

    /**
     * Считываем данные построчно
     * записываем в список строки
     * @param fileName файл для чтения
     */
    private void readFile(String fileName){
        try(BufferedReader reader = new BufferedReader(
                new FileReader(fileName, Charset.forName("UTF-8")))){
            String line = null;
            while((line = reader.readLine()) != null){
                fileLines.add(line);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * записываем данные из списка List в Map
     * @param list список из которого записываем
     */
    private void fillMap(List<String> list) {
        for(String line : list) {
            String[] split = line.trim().split(" ");
            if(result.containsKey(split[0])){
               Double value = Double.parseDouble(split[1]) + result.get(split[0]);
               result.put(split[0], value);
            }else {
                result.put(split[0], Double.parseDouble(split[1]));
            }
        }
    }

    /**
     * вывод содержимого Map в консоль
     * @param map из чего выводим на консоль
     */
    private void outOfConsole(Map<String, Double> map) {
        for(Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        /*
        * можно и так
        for(String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
         */
    }
}
