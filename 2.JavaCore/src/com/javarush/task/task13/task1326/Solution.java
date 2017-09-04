package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            FileInputStream fis = new FileInputStream(str);
            Scanner scanner = new Scanner(fis);
            ArrayList<Integer> arr = new ArrayList<>();
            while(scanner.hasNextInt()){
                int i = scanner.nextInt();
                if(i % 2 == 0){
                    arr.add(i);
                }
            }
            Collections.sort(arr);
            for(int i : arr){
                System.out.println(i);
            }

            br.close();
            fis.close();
            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
