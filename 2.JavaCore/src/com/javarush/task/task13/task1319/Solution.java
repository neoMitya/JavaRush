package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            File file = new File(s);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            //PrintWriter writer = new PrintWriter((bw));

            while(true){
                s = reader.readLine();
                for(char c : s.toCharArray()){
                    bw.append(c);
                }
                bw.newLine();
                if(s.equals("exit")){
                    break;
                }
            }

            reader.close();
            bw.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
