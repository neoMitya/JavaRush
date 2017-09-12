package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        while(!fileName.equals("exit")){
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            fileName = reader.readLine();
        }

    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        @Override
        public void run(){
            try{
                FileInputStream fileReader = new FileInputStream(fileName);
                Map<Integer, Integer> map = new HashMap<>();

                while(fileReader.available() > 0){
                    int c = fileReader.read();
                    map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
                }

                fileReader.close();

                int max = Collections.max(map.values());
                for(Map.Entry<Integer, Integer> pair : map.entrySet()){
                    if(pair.getValue() == max){
                        synchronized(resultMap){
                            resultMap.put(fileName, pair.getKey());
                        }
                    }
                }
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
