package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException{
        //args = new String[]{"e:\\new2.txt"};
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        while(bufferedReader.ready()){
            String[] strings = bufferedReader.readLine().split(" ");
            String date = "", name = "";
            int length = strings.length-1;
            date = String.valueOf(strings[length - 2]) + "." + String.valueOf(strings[length - 1]) + "." + String.valueOf(strings[length]);
            for(int i = 0; i < length-2; i++){
                name += strings[i] + " ";
            }
            DateFormat format = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            Date birthday = format.parse(date);
            Person person = new Person(name.trim(), birthday);
            PEOPLE.add(person);
        }
        bufferedReader.close();
    }
}
