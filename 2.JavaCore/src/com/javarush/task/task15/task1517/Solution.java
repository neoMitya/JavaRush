package com.javarush.task.task15.task1517;

/* 
Статики и исключения
*/

public class Solution {
    public static int A = 0;

    static { if(A == 0) throw new ArithmeticException("Heya");}

    public static int B = 5;

    public static void main(String[] args)  {
        Solution solution = new Solution();
        System.out.println(Solution.B);
    }
}
