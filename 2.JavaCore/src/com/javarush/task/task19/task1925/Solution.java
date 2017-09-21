package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));

        String tmp = reader.lines().flatMap( s -> Arrays.stream( s.split(" ") ) )
                .filter( s -> s.length() > 6 )
                .collect(Collectors.joining(","));
        writer.write(tmp);
        reader.close();
        writer.close();
    }
}
