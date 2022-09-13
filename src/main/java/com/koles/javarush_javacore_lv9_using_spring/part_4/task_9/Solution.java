package com.koles.javarush_javacore_lv9_using_spring.part_4.task_9;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private String file_1 = "C:\\Users\\User\\Desktop\\";
    private String file_2 = "C:\\Users\\User\\Desktop\\";

    private List<String> words;
    public Solution(String[] args){
        file_1 += args[0];
        file_2 += args[1];
        words = new ArrayList<>();
        getLineFromFirstFile();
        writeWordsToFile();
    }

    private void getLineFromFirstFile() {
        try(BufferedReader reader = new BufferedReader( new FileReader(file_1,
                Charset.forName("UTF-8")))) {

            String line = null;
            while ((line = reader.readLine()) !=null){
                String[] split = line.trim().split("[\\p{P} \\n]");
                for(String word : split){
                    if(word.length() > 6)
                        words.add(word);
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeWordsToFile() {
        try(BufferedWriter writer = new BufferedWriter( new FileWriter(file_2,
                Charset.forName("UTF-8")))){

            for(int i = 0; i < words.size(); i++) {
                if(i < words.size() - 1)
                    writer.write(words.get(i) + ",");
                else
                    writer.write(words.get(i) + ".");
            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
