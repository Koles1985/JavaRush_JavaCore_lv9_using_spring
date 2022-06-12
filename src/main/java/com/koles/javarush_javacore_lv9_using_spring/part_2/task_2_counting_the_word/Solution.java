/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koles.javarush_javacore_lv9_using_spring.part_2.task_2_counting_the_word;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author User
 */
@Component("countingWord")
@Scope("prototype")
public class Solution implements Tasks {
    private String fileName = "C:\\Users\\User\\Desktop\\";
    private List<String> wordList;
    public Solution() {
        readConsole();
        wordList = fillList();
        int word = countWordFromList("Орехов", wordList);
        int words = countWordsFromList(wordList);
        System.out.println("Count word Орехов = " + word);
        System.out.println("Count words in file = " + words);
    }
    
    private void readConsole(){
        try(Scanner scanner = new Scanner(System.in)){
            fileName += scanner.nextLine();
        }
    }
    
    private List<String> fillList(){
        List<String> wordList = new ArrayList<>();
        try(FileReader reader = new FileReader(fileName, 
                Charset.forName("UTF-8"))){
            StringBuilder word = new StringBuilder();
            while(reader.ready()){
                char ch = (char)reader.read();
                if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
                    System.out.println(ch);
                    word.append(ch);//формируем слово
                }else if ((ch >= 'а' && ch <= 'я') || (ch >= 'А' && ch <= 'Я')){
                    System.out.println(ch);
                    word.append(ch);//формируем слово
                }else if(!word.toString().equals("")){
                        System.out.println("Else in fillList - " + word.toString());
                        wordList.add(word.toString());// добавляем слово в ArrayList
                        word.delete(0, word.length());//очищаем StringBuilder
                }
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return wordList;
    }
    
    private int countWordFromList(String word, List<String> wordsList){
        int count = 0;
        for(String s : wordsList){
            if(s.equals(word))
                count++;
        }
        return count;
    }
    
    private int countWordsFromList(List<String>wordList){
        return wordList.size();
    }
    
}
