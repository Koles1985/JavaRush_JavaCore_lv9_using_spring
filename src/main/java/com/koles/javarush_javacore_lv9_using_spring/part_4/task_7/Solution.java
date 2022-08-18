package com.koles.javarush_javacore_lv9_using_spring.part_4.task_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {

    private String fileName = "/home/user/Documents/";
    private List<String> words = new ArrayList<>();

    public Solution () {

        getPathFile();
        fillWords();
        readFile(fileName);
    }

    private void getPathFile () {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName += reader.readLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillWords () {
        Collections.addAll(words, "quantity", "world", "enum", "radio", "team", "year");
    }

    private void readFile (String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String[] arrayWordsInStringLine = null;
            String stringLine = null;

            while ((stringLine = reader.readLine()) != null){
                arrayWordsInStringLine = stringLine.trim().split("[\\p{P} \\t\\n\\r]");
                int wordCount = 0;
                for(int i = 0; i < arrayWordsInStringLine.length; i++) {
                    if(words.contains(arrayWordsInStringLine[i])){
                        wordCount++;
                    }
                }
                if(wordCount == 2) {
                    System.out.println(stringLine);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


}
