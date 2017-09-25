package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties prop = new Properties();
    public static String fileName;

    public void fillInPropertiesMap() throws Exception{
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        load(inputStream);
        inputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.clear();
        properties.forEach((k,v)->{prop.put(k,v);});
        prop.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.load(inputStream);
        prop.forEach((k,v)->{properties.put(String.valueOf(k),String.valueOf(v));});
    }

    public static void main(String[] args) throws IOException{

    }
}
