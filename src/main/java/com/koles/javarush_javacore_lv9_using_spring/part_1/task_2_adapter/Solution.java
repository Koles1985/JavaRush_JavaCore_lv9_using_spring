package com.koles.javarush_javacore_lv9_using_spring.part_1.task_2_adapter;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("adapter")
@Scope("prototype")
public class Solution {
    public Solution(){
        System.out.println("Adapter is created!");
    }
    
    public interface AmigoStringWriter{
        void close() throws IOException;
        FileChannel getChanel();
        FileDescriptor getFD() throws IOException;
        void writeString(String s) throws IOException;
        void write(byte[] b, int offset, int length) throws IOException;
        void write(int b) throws IOException;
        void flush()throws IOException;
        
    }
    
    public class AdapterFileOutputStream implements AmigoStringWriter{
        private FileOutputStream fileOutputStream; 
        
        public AdapterFileOutputStream(FileOutputStream fileOutputStream){
            this.fileOutputStream = fileOutputStream;
        }

        @Override
        public void close() throws IOException {
            this.fileOutputStream.close();
        }

        @Override
        public FileChannel getChanel() {
            return this.fileOutputStream.getChannel();
        }

        @Override
        public final FileDescriptor getFD() throws IOException {
            return this.fileOutputStream.getFD();
        }

        @Override
        public void writeString(String s) throws IOException {
            this.fileOutputStream.write(s.getBytes());
        }

        @Override
        public void write(byte[] b, int offset, int length) throws IOException {
            this.fileOutputStream.write(b, offset, length);
        }

        @Override
        public void write(int b) throws IOException {
            this.fileOutputStream.write(b);
        }

        @Override
        public void flush() throws IOException{
            this.fileOutputStream.flush();
        }
        
        
        
    }
    
    
}
