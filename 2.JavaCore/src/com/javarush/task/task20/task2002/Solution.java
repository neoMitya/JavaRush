package com.javarush.task.task20.task2002;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("file", ".txt", new File("e:/temp/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Александр");
            user1.setLastName("Чуднов");
            user1.setBirthDate(simpleDateFormat.parse("21.12.1985"));
            user1.setMale(true);
            user1.setCountry(User.Country.UKRAINE);
            User user2 = new User();
            user2.setFirstName("Соня");
            user2.setLastName("Чуднова");
            user2.setBirthDate(simpleDateFormat.parse("09.10.2003"));
            user2.setMale(false);
            user2.setCountry(User.Country.OTHER);
            User user3 = new User();
            user3.setFirstName("Степан");
            user3.setLastName("Чуднов");
            user3.setBirthDate(simpleDateFormat.parse("06.09.2005"));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);
            javaRush.save(outputStream);
            outputStream.flush();
            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(users.size());

            for(User user : users){
                writer.println(user.getFirstName().isEmpty() ? "null" : user.getFirstName());
                writer.println(user.getLastName().isEmpty() ? "null" : user.getLastName());
                if(user.getBirthDate() != null){
                    writer.println(String.valueOf(user.getBirthDate().getTime()));
                }else{
                    writer.println("null");
                }
                writer.println(user.getCountry().getDisplayedName());
                writer.println(String.valueOf(user.isMale()));
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int count = Integer.parseInt(reader.readLine());
            for(int i = 0; i < count; i++){
                User user = new User();
                String str = reader.readLine();
                user.setFirstName(str.equals("null") ? null : str);
                str = reader.readLine();
                user.setLastName(str.equals("null") ? null : str);
                str = reader.readLine();
                user.setBirthDate(new Date(Long.parseLong(str)));
                str = reader.readLine();
                if (str.equals(User.Country.RUSSIA.getDisplayedName())) user.setCountry(User.Country.RUSSIA);
                if (str.equals(User.Country.UKRAINE.getDisplayedName())) user.setCountry(User.Country.UKRAINE);
                if (str.equals(User.Country.OTHER.getDisplayedName())) user.setCountry(User.Country.OTHER);
                str = reader.readLine();
                user.setMale(Boolean.parseBoolean(str));
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
