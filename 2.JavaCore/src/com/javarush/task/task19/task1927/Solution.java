package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        testString.printSomething();
        String[] result = outputStream.toString().split("\n");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.length; i++){
            sb.append(result[i]).append("\n");
            if((i+1)%2 == 0){
                sb.append("JavaRush - курсы Java онлайн").append("\n");
            }
        }
        System.setOut(consoleStream);
        System.out.println(sb.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
