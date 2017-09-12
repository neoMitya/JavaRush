package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = null;
        String fileName = "";

        while(true){
            try{
                fileName = reader.readLine();
                file = new FileInputStream(fileName);
                file.close();
            }catch(FileNotFoundException e){
                System.out.println(fileName);
                break;
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
