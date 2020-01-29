package ua.textcontainer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> textContainer = TextContainer.class;
        SaveToFile saveToFile = textContainer.getAnnotation(SaveToFile.class);
        String uFile = saveToFile.str();

        Method[] methods = textContainer.getDeclaredMethods();

        for (Method method : methods){
            System.out.println(" method =  " + method);
            if(method.isAnnotationPresent(Saver.class)){
                System.out.println(" method isAnnotationPresent(Saver.class) =  " + method);
                method.invoke(textContainer.newInstance(), uFile);
            }
        }
    }
}
