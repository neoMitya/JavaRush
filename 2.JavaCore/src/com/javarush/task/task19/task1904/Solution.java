package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        @Override
        public Person read() throws IOException, ParseException{
            String firstName = null;
            String middleName = null;
            String lastName = null;
            String date;
            Date birthDate = null;

            if(fileScanner.hasNextLine()){
                String personString = fileScanner.nextLine();
                String[] strings = personString.split(" ");
                firstName = strings[1];
                middleName = strings[2];
                lastName = strings[0];
                date = strings[3] + "-" + strings[4] + "-" + strings[5];
                DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                birthDate = format.parse(date);
            }

            return new Person(firstName,middleName,lastName,birthDate);
        }

        @Override
        public void close() throws IOException{
            this.fileScanner.close();
        }

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }
    }
}
