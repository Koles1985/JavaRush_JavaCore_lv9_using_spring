package com.koles.javarush_javacore_lv9_using_spring.part_4.task_2;

import java.io.*;

public class FileConsoleWriter implements AutoCloseable {

    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter (File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter (File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter (String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter (FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        for(int i = off; i < len; i++) {
            System.out.print(cbuf[i]);
        }
        fileWriter.write(cbuf, off, len);
    }

    public void write(int c) throws IOException {
        System.out.print((char)c);
        fileWriter.write(c);
    }

    public void write(String str) throws IOException {
        System.out.println(str);
        fileWriter.write(str);
    }

    public void write(String str, int off, int len) throws IOException {
        System.out.println(str.substring(off, len));
        fileWriter.write(str, off, len);
    }

    public void write(char[] cbuf) throws IOException {
        for(int i = 0; i < cbuf.length; i++){
            System.out.print(cbuf[i]);
        }
        fileWriter.write(cbuf);
    }

    @Override
    public void close() throws IOException {
        fileWriter.close();
    }
}
