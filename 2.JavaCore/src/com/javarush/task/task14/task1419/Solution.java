package com.javarush.task.task14.task1419;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        //напишите тут ваш код
        try {
            Integer.parseInt("i");

        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new EOFException());
        exceptions.add(new FileNotFoundException());
        exceptions.add(new ArrayIndexOutOfBoundsException());
        exceptions.add(new ArrayStoreException());
        exceptions.add(new ClassCastException());
        exceptions.add(new ClassFormatException());
        exceptions.add(new InterruptedException());
        exceptions.add(new InputMismatchException());
    }
}
