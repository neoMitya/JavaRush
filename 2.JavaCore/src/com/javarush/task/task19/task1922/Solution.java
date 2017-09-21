package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    static int count = 0;

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(consoleReader.readLine()));
        consoleReader.close();

        while(bufferedReader.ready()){
            String temp = bufferedReader.readLine();
            String[] strings = temp.split(" ");
            count = 0;
            for(String str : strings){
                words.forEach((s)->{if(s.equals(str)){ increment(); }});
            }

            if(count == 2){
                System.out.println(temp);
            }
        }
        bufferedReader.close();
    }

    private static void increment(){
        count++;
    }
}
