package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date;

        if(args[0].equals("-c")){
            try{
                date = simpleDateFormat.parse(args[3]);
            }catch(ParseException e){
                date = new Date();
            }
            if(args[2].equals("м")){
                allPeople.add(Person.createMale(args[1], date));
            }else if(args[2].equals("ж")){
                allPeople.add(Person.createFemale(args[1], date));
            }
            System.out.println(allPeople.size() - 1);
        }else if(args[0].equals("-u")){
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setName(args[2]);
            if(args[3].equals("м")){
                allPeople.get(id).setSex(Sex.MALE);
            }else if(args[3].equals("ж")){
                allPeople.get(id).setSex(Sex.FEMALE);
            }
            try{
                date = simpleDateFormat.parse(args[4]);
            }catch(ParseException e){
                date = new Date();
            }
            allPeople.get(id).setBirthDay(date);
        }else if(args[0].equals("-d")){
            int id = Integer.parseInt(args[1]);
            Person p = allPeople.get(id);
            p.setBirthDay(null);
            p.setSex(null);
            p.setName(null);
        }else if(args[0].equals("-i")){
            int id = Integer.parseInt(args[1]);
            simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Person p = allPeople.get(id);
            System.out.println(p.getName() + (p.getSex()==Sex.MALE?" м ":" ж ") + simpleDateFormat.format(p.getBirthDay()));
        }
    }
}
