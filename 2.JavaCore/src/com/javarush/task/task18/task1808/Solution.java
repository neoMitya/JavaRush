package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream fileInputStream0 = new FileInputStream(file1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(file2);
        FileOutputStream  fileOutputStream2 = new FileOutputStream(file3);

        int count = 0;
        int availableCount = fileInputStream0.available();
        byte[] buff = new byte[fileInputStream0.available()];

        count = fileInputStream0.read(buff);
        fileOutputStream1.write(buff, 0 , count / 2 + count % 2);
        fileOutputStream2.write(buff, count / 2 + count % 2, count / 2);

        fileInputStream0.close();
        fileOutputStream1.close();
        fileOutputStream2.close();
        reader.close();


    }
}
