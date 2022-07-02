package com.koles.javarush_javacore_lv9_using_spring.part_4.task_1;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Component("trackingChanges")
@Scope("prototype")
public class Solution implements Tasks {

    private String fileName_1 = "C:\\Users\\User\\Desktop\\";
    private String fileName_2 = "C:\\Users\\User\\Desktop\\";
    private List<String> textFromFile_1;
    private List<String> textFromFile_2;
    private List<String> lines = new ArrayList<>();
    public Solution() {

        setFileNames();
        textFromFile_1 = getStringsFromFile(fileName_1);
        textFromFile_2 = getStringsFromFile(fileName_2);
        fillLines(textFromFile_1, textFromFile_2);

        System.out.println(lines);
    }

    /**
     * Получаем имена двух файлов на рабочем столе
     * fileName_1 и fileName_2
     */
    private void setFileNames(){
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName_1 += reader.readLine();
            fileName_2 += reader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Читает строки из файла и записывает в список
     * @param fileName имя файла из которого читать строки
     * @return List<String></>
     */
    private List<String> getStringsFromFile(String fileName){
        List<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName,
                Charset.forName("UTF-8")))){

            while(reader.ready()){
                list.add(reader.readLine());
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return list;
    }

    /**
     * Зоплняет список lines
     * @param list_1 список 1
     * @param list_2 список 2
     */
    private void fillLines(List<String> list_1, List<String> list_2) {

        for(int i = 0, j = 0; i < list_1.size(); i++, j++){
            String textFromList_1 = list_1.get(i);
            String textFromList_2 = list_2.get(j);
            if(list_2.contains(textFromList_1))
                lines.add("SAME" + textFromList_1);
            else
                lines.add("REMOVED" + textFromList_1);

            if(!list_1.contains(textFromList_2))
                lines.add("ADDED" + textFromList_2);
        }

        int difference = list_1.size() - list_2.size();
        if (difference < 0) {
            System.out.println(difference);
            int index = list_2.size() + difference;
            System.out.println(index);
            System.out.println(list_2.size());
            for (;index < list_2.size(); index++){
                lines.add("ADDED" + list_2.get(index));
            }
        }
    }
}
