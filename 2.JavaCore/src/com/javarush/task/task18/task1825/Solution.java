package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        Set<String> set = new TreeSet<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = null;
        String str = "";

        while(!str.equals("end")){
            str = reader.readLine();
            if(str.equals("end")){
                break;
            }
            set.add(str);
        }

        if(set.size() > 0){
            str = String.valueOf(set.toArray()[0]);
            str = str.substring(0, str.lastIndexOf(".part"));
            fileOutputStream = new FileOutputStream(str);
        }

        for(String fileName : set){
            FileInputStream fileInputStream = new FileInputStream(fileName);
            int count = fileInputStream.available();
            byte[] buff = new byte[count];
            fileInputStream.read(buff, 0, count);
            fileOutputStream.write(buff, 0, count);
            fileOutputStream.flush();
            fileInputStream.close();
        }

        reader.close();
        fileOutputStream.close();
    }
}
