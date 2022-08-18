package com.koles.javarush_javacore_lv9_using_spring.part_4.task_8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    private String fileInput = "/home/user/Documents/";
    private String fileOutput = "/home/user/Documents/";

    private List<String> wordsList = new ArrayList<>();

    public Solution (String[] args) {
        fileInput += args[0];
        fileOutput += args[1];
        readFile(fileInput);
        writeFile(fileOutput);
    }

    /**
     * Читает файл и записывает подходящие слова
     * в поле класса wordsList типа List
     * @param fileInput - файл для чтения
     */
    private void readFile (String fileInput) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileInput))) {
            String line = null;
            String[] splitLine = null;

            while (reader.ready()) {
                line = reader.readLine();
                splitLine = line.trim().split(" ");
                for(String word : splitLine){
                    if(isContainsNumber(word)) {
                        wordsList.add(word);
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * проверяет содежит ли слово цыры
     * возвращает соответствующий результат
     * @param word - проверяемое слово
     * @return - true если содержит, false если не содержит
     */
    private boolean isContainsNumber (String word) {
        for(char symbol : word.toCharArray()) {
            if(Character.isDigit(symbol)) {
                return true;
            }
        }
        return false;
    }

    /**
     * записывает слова из поля wordsList в файл
     * @param fileOutput - файл для записи
     */
    private void writeFile (String fileOutput) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput))) {
            for (String word : wordsList) {
                writer.write(word + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
