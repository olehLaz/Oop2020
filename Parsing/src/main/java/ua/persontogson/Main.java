package ua.persontogson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] buf;
        RandomAccessFile f = new RandomAccessFile("folderProject\\persons.json", "r");
        try {
            buf = new byte[(int)f.length()];
            f.read(buf);
        } finally {
            f.close();
        }

        String result = new String(buf);
        System.out.println("----json----------");
        System.out.println(result);
        System.out.println("--------------------");

        Gson gson = new GsonBuilder().create();
        Person person = gson.fromJson(result, Person.class);

        System.out.println(person.getName());
        System.out.println(person.getSurname());
        System.out.print(Arrays.toString(person.getPhones()));
        System.out.println();
        System.out.print(Arrays.toString(person.getSites()));
        System.out.println();
        System.out.print(person.getAddress().getStreet() + "\t");
        System.out.print(person.getAddress().getCity() + "\t");
        System.out.println(person.getAddress().getCountry());

    }
}
