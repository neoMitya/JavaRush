package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);

        Set<Integer> set = new TreeSet<>();
        while(fileInputStream.available() > 0){
            int data = fileInputStream.read();
            set.add(data);
        }
        fileInputStream.close();
        reader.close();
        if(set.isEmpty()){
            return;
        }

        for(int i : set){
            System.out.print(i + " " );
        }
    }
}
