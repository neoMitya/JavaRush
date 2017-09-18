package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    /*public FileConsoleWriter(FileWriter fileWriter){
        this.fileWriter = fileWriter;
    }*/
    public FileConsoleWriter(File file) throws IOException{
        this.fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException{
        this.fileWriter = new FileWriter(file, append);
    }
    public FileConsoleWriter(FileDescriptor fd){
        this.fileWriter = new FileWriter(fd);
    }
    public FileConsoleWriter(String fileName) throws IOException{
        this.fileWriter = new FileWriter(fileName);
    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException{
        this.fileWriter = new FileWriter(fileName, append);
    }
    private FileWriter fileWriter;

    public void write(char[] cbuf, int off, int len) throws IOException{
        this.fileWriter.write(cbuf,off,len);
        System.out.println(String.valueOf(cbuf,off,len));
    }
    public void write(int c) throws IOException{
        this.fileWriter.write(c);
        System.out.println(String.valueOf(c));
    }
    public void write(String str) throws IOException{
        this.fileWriter.write(str);
        System.out.println(str);
    }
    public void write(String str, int off, int len) throws IOException{
        this.fileWriter.write(str,off,len);
        System.out.println(String.valueOf(str.toCharArray(),off,len));
    }
    public void write(char[] cbuf) throws IOException{
        this.fileWriter.write(cbuf);
        System.out.println(String.valueOf(cbuf));
    }
    public void close() throws IOException{
        this.fileWriter.close();
    }

    public static void main(String[] args) {

    }

}
