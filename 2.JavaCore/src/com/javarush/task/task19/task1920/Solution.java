package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;

public class Solution {
    private static TreeMap<String, Double> map = new TreeMap<String, Double>();

    public static void main(String[] args) throws IOException{
        //args = new String[]{"e:\\new2.txt"};
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        while(bufferedReader.ready()){
            String[] strings = bufferedReader.readLine().split(" ");
            addMap(strings[0], Double.parseDouble(strings[1]));
        }
        bufferedReader.close();

        double max = getMax();

        map.forEach((k,v)->{if(v.equals(max)){
            System.out.println(k);
        }});
    }

    private static double getMax(){
        return Collections.max(map.values());
    }

    private static void addMap(String name, Double value) {
        if (!map.containsKey(name))
            map.put(name,value);
        else
            map.put(name, map.get(name) + value);
    }
}
