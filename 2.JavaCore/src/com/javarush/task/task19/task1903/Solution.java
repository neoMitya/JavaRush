package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        @Override
        public String getCompanyName(){
            return data.getCompany();
        }

        @Override
        public String getCountryName(){
            return Solution.countries.get(data.getCountryCode());
        }

        @Override
        public String getName(){
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber(){
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            for(int i = 0; i < 10 - String.valueOf(data.getPhoneNumber()).length(); i++){
                if(sb.toString().length() == 4){
                    sb.append(")");
                }
                if(sb.toString().length() == 8){
                    sb.append("-");
                }
                if(sb.toString().length() == 11){
                    sb.append("-");
                }
                sb.append("0");
            }
            for(int i = 0; i < String.valueOf(data.getPhoneNumber()).length(); i++){
                if(sb.toString().length() == 4){
                    sb.append(")");
                }
                if(sb.toString().length() == 8){
                    sb.append("-");
                }
                if(sb.toString().length() == 11){
                    sb.append("-");
                }
                sb.append(String.valueOf(data.getPhoneNumber()).charAt(i));
            }

            return "+" + data.getCountryPhoneCode() + sb.toString();
        }

        public IncomeDataAdapter(IncomeData incomeData){
            this.data = incomeData;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}