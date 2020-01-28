package ua.getclass1;

import java.lang.reflect.*;

public class MainRectangle1 {
    public static void main(String[] args) {


        Class classRectangle = Rectangle.class;
        Rectangle rectOne = new Rectangle(2, 4);
        Class classRectOne = rectOne.getClass();
        Field[] fieldArray = classRectOne.getDeclaredFields();
        for (Field field : fieldArray) {
            System.out.println(field);

        }
        System.out.println();
        Method[] methods = classRectangle.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        Constructor<?>[] constructor = classRectOne.getConstructors();
        for (Constructor<?> constructor1 : constructor) {
            System.out.println(constructor1);
        }

        System.out.println();
        System.out.println(rectOne);
        try {
            Field w = classRectOne.getDeclaredField("width");
            w.setAccessible(true);
            w.setDouble(rectOne, 10);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(rectOne);

        System.out.println(" main method stop !! ");

    }
}
