package com.koles.javarush_javacore_lv9_using_spring.part_4.task_2;

import com.koles.javarush_javacore_lv9_using_spring.Tasks;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Component("selfFileWriter")
@Scope("prototype")
public class Solution implements Tasks {

    private String writeFile = "C:\\Users\\User\\Desktop\\test2.txt";
    private String readFile = "C:\\Users\\User\\Desktop\\test.txt";

    public Solution() {
        writeToFile();

    }

    private void writeToFile() {
        try( FileConsoleWriter fileConsoleWriter = new FileConsoleWriter(writeFile);
             FileReader reader = new FileReader(readFile)) {

            while (reader.ready()) {
                char[] buf = new char[100];
                int i = reader.read(buf);

                fileConsoleWriter.write(buf);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
