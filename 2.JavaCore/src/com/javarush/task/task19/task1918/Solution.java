package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{
        //args = new String[]{"b"};
        String tag = args[0];
        String openTag = "<" + tag;
        String closeTag = "</" + tag + ">";
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String file = consoleReader.readLine();
        consoleReader.close();

        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = "";
        StringBuilder sb = new StringBuilder();
        while(reader.ready()){
            line = reader.readLine();
            sb.append(line);
        }
        fileReader.close();

        ArrayList<Integer> openTagArr = new ArrayList<Integer>();
        ArrayList<Integer> closeTagArr = new ArrayList<Integer>();
        line = sb.toString().replaceAll("\r?\n", ""); //remove all line breaks;
        int openIndex = 0;
        int closeIndex = 0;
        for(int i = 0; i < line.length(); i++){
            openIndex = line.indexOf(openTag, i + openIndex);
            closeIndex = line.indexOf(closeTag, i + closeIndex);
            if(openIndex == -1 || closeIndex == -1){
                break;
            }
            openTagArr.add(openIndex);
            closeTagArr.add(closeIndex);
        }
        ArrayList<Integer> tagArr = new ArrayList<Integer>();
        tagArr.addAll(openTagArr);
        tagArr.addAll(closeTagArr);
        Collections.sort(tagArr);

        ArrayList<Tag> arr = new ArrayList<Tag>();

        openIndex = 0;
        closeIndex = 0;
        for(int i = 0; i < tagArr.size();){
            if(tagArr.get(i) == openTagArr.get(openIndex) && tagArr.get(i+1) == closeTagArr.get(closeIndex)){
                i += 2;
                arr.add(new Tag(openTagArr.get(openIndex++), closeTagArr.get(closeIndex++)));
            }else{
                int k = 0;
                while(openTagArr.get(openIndex) < closeTagArr.get(closeIndex)){
                    openIndex++;
                    k++;
                }
                ArrayList<Tag> arrTemp = new ArrayList<Tag>();
                for(int j = 1; j <= k; j++){
                    arrTemp.add(new Tag(openTagArr.get(openIndex - j), closeTagArr.get(closeIndex++)));
                }
                for(int j = arrTemp.size()-1; j >= 0; j--){
                    arr.add(arrTemp.get(j));
                }
                i += k*2;
            }
        }

        for(Tag t : arr){
            System.out.println(line.substring(t.openTag, t.closeTag + closeTag.length()));
        }

    }
    private static class Tag{
        public int openTag;
        public int closeTag;

        public Tag(int openTag, int closeTag){
            this.openTag = openTag;
            this.closeTag = closeTag;
        }
    }
}
