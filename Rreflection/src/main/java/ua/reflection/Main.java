package ua.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Tested ts = new Tested();
        Class<?> cls = ts.getClass();
        try {
            Method[] mtd = cls.getDeclaredMethods();
            for (Method m : mtd) {
                if(m.isAnnotationPresent(Test.class)) {
                    Test test = m.getDeclaredAnnotation(Test.class);
                    m.invoke(ts, test.a(), test.b());
                }
            }
        } catch (ReflectiveOperationException e) {
            System.out.println(e.toString());
        }
    }
}
