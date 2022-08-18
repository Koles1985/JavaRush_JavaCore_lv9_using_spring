package com.koles.javarush_javacore_lv9_using_spring.part_4.task_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public final List<Person> PEOPLE = new ArrayList<>();
    public Solution(String[] args) {
        String fileName;
        if(args.length < 1) {
            return;
        }else {
            fileName = "/home/user/Documents/" + args[0];
        }

        List<String> lines = readFile(fileName);
        initPerson(lines);
        for (Person person : PEOPLE) {
            System.out.println(person.toString());
        }
    }

    private List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(
                new FileReader(fileName, Charset.forName("UTF-8")))) {

            while (reader.ready()) {
                lines.add(reader.readLine());
            }

        }catch(IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    private void initPerson (List<String> list) {
        int[] date = new int[3];
        StringBuilder name = new StringBuilder();
        Person person;

        for(String line : list) {
            String[] split = line.trim().split(" ");
            for(int i = 0, j = 0; i < split.length; i++) {
                try {
                    date[j] = Integer.parseInt(split[i]);
                    j++;
                }catch (NumberFormatException e) {
                    name.append(split[i] + " ");
                }
            }
            person = new Person(name.toString().trim(), date[0], date[1], date[2]);
            name.delete(0, name.length());
            PEOPLE.add(person);

        }

    }
}
