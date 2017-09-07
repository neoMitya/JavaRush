package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        //args = new String[]{"-c", "Миронов", "м", "15/04/1990"};
        switch(args[0]){
            case("-c"): synchronized(allPeople){Create(args);}
                break;
            case("-u"): synchronized(allPeople){Update(args);}
                break;
            case("-d"): synchronized(allPeople){Delete(args);}
                break;
            case("-i"):synchronized(allPeople){Info(args);}
                break;
        }
    }
//-c name1 sex1 bd1 name2 sex2 bd2 ...
    private static void Create(String[] params){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;

        for(int i = 1; i < params.length; i += 3){
            try{
                date = simpleDateFormat.parse(params[i + 2]);
            }catch(ParseException e){
                e.getMessage();
            }
            Person p = null;
            if(params[i + 1].equals("м")){
                p = Person.createMale(params[i], date);
            }else if(params[i + 2].equals("ж")){
                p = Person.createFemale(params[i], date);
            }
            allPeople.add(p);
            System.out.println(allPeople.indexOf(p));
        }
    }
    //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
    private static void Update(String[] params){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;

        for(int i = 1; i < params.length; i += 4){
            int id = Integer.parseInt(params[i]);
            Person p = allPeople.get(id);
            p.setName(params[i + 1]);
            if(params[i + 2].equals("м")){
                p.setSex(Sex.MALE);
            }else if(params[i + 2].equals("ж")){
                p.setSex(Sex.FEMALE);
            }
            try{
                date = simpleDateFormat.parse(params[i + 3]);
            }catch(ParseException e){
                e.getMessage();
            }
            p.setBirthDay(date);
        }
    }

    private static void Delete(String[] params){
        for(int i = 1; i < params.length; i++){
            int id = Integer.parseInt(params[i]);
            Person p = allPeople.get(id);
            p.setBirthDay(null);
            p.setSex(null);
            p.setName(null);
        }
    }

    private static void Info(String[] params){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date date;

        for(int i = 1; i < params.length; i++){
            int id = Integer.parseInt(params[i]);
            simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Person p = allPeople.get(id);
            System.out.println(p.getName() + (p.getSex()==Sex.MALE?" м ":" ж ") + simpleDateFormat.format(p.getBirthDay()));
        }
    }
}
