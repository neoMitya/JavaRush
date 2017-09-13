package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        //args = new String[]{"-u", "198478", "product Name1", "9876543210", "qwerty"};
        if(args.length == 0){
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileReader fileReader = new FileReader(fileName);
        reader = new BufferedReader(fileReader);

        Map<BigInteger,String> map = new LinkedHashMap<BigInteger, String>(15, 0.75f, false);
        while(reader.ready()){
            String line = reader.readLine();
            if(!line.isEmpty()){
                map.put(new BigInteger(line.substring(0, 8).trim()), line.substring(8));
            }
        }
        reader.close();
        fileReader.close();

        if(args[0].equals("-c")){
            BigInteger maxID = Collections.max(map.keySet());
            maxID = maxID.add(BigInteger.valueOf(1));
            Product product = new Product(maxID.toString(), args[1], args[2], args[3]);
            map.put(maxID, product.getString());
            //sb.append(product.toString().toCharArray());
        }else if(args[0].equals("-u")){
            BigInteger ID = BigInteger.valueOf(Long.parseLong(args[1]));
            Product product = new Product(args[2], args[3], args[4]);
            map.put(ID,product.getString());
        }else if(args[0].equals("-d")){
            BigInteger ID = BigInteger.valueOf(Long.parseLong(args[1]));
            map.remove(ID);
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<BigInteger,String> pair : map.entrySet()){
            char[] id = new char[8];
            Arrays.fill(id,' ');

            for(int i = 0; i < id.length && i < pair.getKey().toString().length(); i++){
                id[i] = pair.getKey().toString().charAt(i);
            }
            for(char c : id){
                sb.append(c);
            }
            sb.append(pair.getValue()).append("\n");
        }

        writer.write(sb.toString());
        writer.close();
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

        public Product(String productName, String price, String quantity){
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

        public void update(String productName, String price, String quantity){
            Arrays.fill(this.productName,' ');
            Arrays.fill(this.price,' ');
            Arrays.fill(this.quantity,' ');
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

        public String getString(){
            StringBuilder sb = new StringBuilder();
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
