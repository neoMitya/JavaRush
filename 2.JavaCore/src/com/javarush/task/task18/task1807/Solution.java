package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);


        int count = 0;
        while(fileInputStream.available() > 0){
            char data = (char) fileInputStream.read();
            if(data == ','){
                count++;
            }
        }
        fileInputStream.close();
        reader.close();

        System.out.println(count);
    }
}
