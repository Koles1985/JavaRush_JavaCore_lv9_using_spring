package com.koles.javarush_javacore_lv9_using_spring.part_4.task_10;

import java.io.*;
import java.nio.charset.Charset;

public class Solution {

    private String fileName = "C:\\Users\\User\\Desktop\\";

    public Solution() {
        getFileNameFromConsole();
        readFile();
    }

    private void getFileNameFromConsole() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName += reader.readLine();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName,
                Charset.forName("UTF-8")))){
                String line = null;
                StringBuilder builder = new StringBuilder();
                while((line = reader.readLine()) != null) {
                    builder.append(line);
                    System.out.println(builder.reverse().toString());
                    builder.delete(0, builder.length());
                }


        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
