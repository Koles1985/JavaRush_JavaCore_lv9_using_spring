package com.koles.javarush_javacore_lv9_using_spring.part_4.task_3;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution implements Tasks {

    private String fileName = "C:\\Users\\User\\Desktop\\";

    public Solution(String[] args){
        String argument = null;
        if(args.length > 0){
            argument = args[0];
        }
        getFileName();
        fillTagList(fileName, argument);


    }

    private void getFileName(){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName += reader.readLine();
        }catch(IOException e){
            //NOT
        }
    }


    private void fillTagList(String fileName, String arg){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                String line = reader.readLine();
                if(line.contains(arg)){
                    System.out.println(getTagsFromString(line, arg));
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private String getTagsFromString(String line, String arg){
        String temp = line.replaceAll("[\\r\\n ]+", "");
        int firstOccurrence = temp.indexOf(arg);
        int lastOccurrence = temp.lastIndexOf(arg);
        if(firstOccurrence == lastOccurrence){
            if(temp.charAt(firstOccurrence - 1) == '<')
                return temp.substring(firstOccurrence - 1);
            else
                return temp.substring(0, lastOccurrence + arg.length() + 1);
        }

        else if(temp.charAt(lastOccurrence - 1) != '/')
            return temp.substring(firstOccurrence - 1);
        else
            return temp.substring(firstOccurrence - 1, lastOccurrence + arg.length() + 1);
    }
}
