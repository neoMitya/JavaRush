package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = reader.readLine();
            if(str.equals("exit")){break;}

            try{
                if(str.contains(".")){
                    print(Double.valueOf(str));
                }else if(Integer.valueOf(str) > 0 && Integer.valueOf(str) < 128){
                    print(Short.valueOf(str));
                }else if(Integer.valueOf(str) <= 0 || Integer.valueOf(str) >= 128){
                    print(Integer.valueOf(str));
                }
            }catch(NumberFormatException e){
                print(str);
            }

        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
