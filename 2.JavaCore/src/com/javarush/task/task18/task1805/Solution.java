package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);

        Map<Integer, Integer> map = new TreeMap<>();
        while(fileInputStream.available() > 0){
            int data = fileInputStream.read();
            map.put(data, null);
        }
        fileInputStream.close();
        reader.close();
        if(map.isEmpty()){
            return;
        }

        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            System.out.print(pair.getKey() + " " );
        }
    }
}
