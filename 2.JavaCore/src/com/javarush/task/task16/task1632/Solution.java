package com.javarush.task.task16.task1632;

//import com.javarush.task.task14.task1408.BelarusianHen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread{
        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()){}
        }
    }
    public static class Thread2 extends Thread{
        @Override
        public void run(){
            try{
                while(true){
                    Thread.sleep(1);
                }
            }catch(InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thread3 extends Thread{
        @Override
        public void run(){
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Ура");
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Thread4 extends Thread implements Message{
        @Override
        public void run(){
            showWarning();
        }

        @Override
        public void showWarning(){
            if(isAlive()){
                interrupt();
            }
        }
    }
    public static class Thread5 extends Thread{
        @Override
        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Integer integer = new Integer(0);
            String s = "";
            while(true){
                try{
                    s = reader.readLine();
                    if(s.equals("N")){
                        break;
                    }
                    integer = integer + Integer.parseInt(s);

                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            System.out.println(integer);
        }
    }

}