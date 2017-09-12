package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //args = new String[]{"-c", "product Name", "0123456789"};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileReader fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);
        StringBuilder sb = new StringBuilder();

        Set<BigInteger> set = new TreeSet<BigInteger>();
        while(reader.ready()){
            String line = reader.readLine();
            if(!line.isEmpty()){
                sb.append(line).append("\n");
                line = line.substring(0, 8).trim();
                set.add(new BigInteger(line));
            }
        }
        reader.close();
        fileReader.close();

        BigInteger maxID = Collections.max(set);
        //BigInteger bigInteger = new BigInteger(maxID);
        maxID = maxID.add(BigInteger.valueOf(1));

        if(args[0].equals("-c")){
            Product product = new Product(maxID.toString(), args[1], args[2], args[3]);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            sb.append(product.toString().toCharArray());
            writer.write(sb.toString());
            writer.close();
        }

    }

    private static class Product{
        private static char[] id = new char[8];
        private static char[] productName = new char[30];
        private static char[] price = new char[8];
        private static char[] quantity = new char[4];
        static {
            Arrays.fill(id,' ');
            Arrays.fill(productName,' ');
            Arrays.fill(price,' ');
            Arrays.fill(quantity,' ');
        }

        public Product(String id, String productName, String price, String quantity){
            for(int i = 0; i < this.id.length && i < id.length(); i++){
                this.id[i] = id.charAt(i);
            }
            for(int i = 0; i < this.productName.length && i < productName.length(); i++){
                this.productName[i] = productName.charAt(i);
            }
            for(int i = 0; i < this.price.length && i < price.length(); i++){
                this.price[i] = price.charAt(i);
            }
            for(int i = 0; i < this.quantity.length && i < quantity.length(); i++){
                this.quantity[i] = quantity.charAt(i);
            }
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(char c : id){
                sb.append(c);
            }
            for(char c : productName){
                sb.append(c);
            }
            for(char c : price){
                sb.append(c);
            }
            for(char c : quantity){
                sb.append(c);
            }

            return sb.toString();
        }
    }
}
