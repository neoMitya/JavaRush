package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNme = reader.readLine();
        //int ad = Integer.valueOf(args[0]);

        reader = new BufferedReader(new FileReader(fileNme));
        while(reader.ready()){
            String buff = reader.readLine();
            String[] strings = buff.split(" ");
            if(strings[0].equals(args[0])){
                System.out.println(buff);
            }
        }

        reader.close();
    }
}
