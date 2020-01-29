package ua.reflectioncat;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Cat implements Serializable {
    private static final long serialVersionUID = 1L;

    @Save
    private  String name;
    private String eyes;
    @Save
    private int age;
    private double mass;

    public Cat(String name, String eyes, int age, double mass) {
        this.name = name;
        this.eyes = eyes;
        this.age = age;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public static void serializable(Cat cat, String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            List<Object> annotatedFields = new ArrayList<>();
            Class<?> clazz = cat.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                if (f.isAnnotationPresent(Save.class)) {
                    Object fieldValue = f.get(cat);
                    annotatedFields.add(fieldValue);
                }
            }
            oos.writeObject(annotatedFields);
        } catch (IOException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static List<Object> deSerializable(String path) {
        List<Object> fields = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path))) {
            fields = (List<Object>) reader.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return fields;
    }
        @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", eyes='" + eyes + '\'' +
                ", age=" + age +
                ", mass=" + mass +
                '}';
    }
}
