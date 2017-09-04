package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код

        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = "";
            s = reader.readLine();
            FileInputStream inputStream = new FileInputStream(s);
            Scanner scanner = new Scanner(inputStream);
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            if(inputStream != null){
                inputStream.close();
            }
            scanner.close();
            reader.close();
            inputStream.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}