package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);

        Map<Integer, Integer> map = new TreeMap<>();
        while(fileInputStream.available() > 0){
            int data = fileInputStream.read();
            map.put(data, map.get(data) == null ? 1 : map.get(data) + 1);
        }
        fileInputStream.close();
        reader.close();
        if(map.isEmpty()){
            return;
        }

        int min = Integer.MAX_VALUE;
        for(int i : map.values()){
            if(i < min){
                min = i;
            }
        }

        for(Map.Entry<Integer, Integer> pair : map.entrySet()){
            if(min == pair.getValue()){
                System.out.print(pair.getKey() + " " );
            }
        }
    }
}
