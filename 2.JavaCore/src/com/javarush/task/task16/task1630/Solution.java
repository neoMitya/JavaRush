package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName = "";
    public static String secondFileName = "";

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private static volatile String fileName = null;
        private static volatile String sb = "";

        @Override
        public void setFileName(String fullFileName){
            fileName = fullFileName;
        }

        @Override
        public String getFileContent(){
            return sb;
        }

        @Override
        public void run(){
            FileReader  fileReader = null;
            BufferedReader reader = null;
            try{
                fileReader = new FileReader(fileName);
                reader = new BufferedReader(fileReader);


                if(reader.ready()){
                    String sCurrentLine;

                    while ((sCurrentLine = reader.readLine()) != null){
                        sb = sb + sCurrentLine + " ";
                    }
                }

            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                try{
                    if (reader != null){
                        reader.close();
                    }
                    if (fileReader != null){
                        fileReader.close();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public interface ReadFileInterface extends Runnable {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
}
