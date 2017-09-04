package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();

        url = url.substring(url.indexOf("?")+1);
        String[] strs = url.split("&");
        String buf = null;
        for(String str : strs){
            String[] tmp = str.split("=");
            System.out.print(tmp[0] + " ");
            if(tmp[0].equals("obj")){
                buf = tmp[1];
            }
        }
        System.out.println("");
        try{
            alert(Double.valueOf(buf));
        }catch(Exception e){
            if(buf != null){
                alert(buf);
            }
        }
        scanner.close();
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
