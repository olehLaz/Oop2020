package ua.reflectionrectangle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Rectangle rectangle = new Rectangle();
        Class<?> cls = rectangle.getClass();
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            System.out.println(" method =  " + m);
            if(m.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation myAnnotation = m.getAnnotation(MyAnnotation.class);
                int res = (Integer) m.invoke(rectangle, myAnnotation.sizeA(), myAnnotation.sizeB());
                System.out.println(res);
            }

        }



    }
}
