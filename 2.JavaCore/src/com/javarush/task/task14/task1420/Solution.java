package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String n1 = scanner.nextLine();
        String n2 = scanner.nextLine();
        int min = 0;
        //int nod = 0;

            int i1 = Integer.parseInt(n1, 10);
            int i2 = Integer.parseInt(n2, 10);
            if(i1 <= 0 || i2 <= 0){
                throw new Exception();
            }
            min = i1 < i2 ? i1 : i2;

            while(min > 0){
                if(i1 % min == 0 && i2 % min == 0){
                    //nod = min;
                    System.out.println(min);
                    break;
                }
                min--;
            }
    }
}
