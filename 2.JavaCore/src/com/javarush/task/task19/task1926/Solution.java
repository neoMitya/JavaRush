package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    static String tmp = "";
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));

        fileReader.lines().forEach((s)->{tmp += new StringBuilder(s).reverse().toString() + "\n";});

        System.out.println(tmp);
        reader.close();
        fileReader.close();
    }
}
