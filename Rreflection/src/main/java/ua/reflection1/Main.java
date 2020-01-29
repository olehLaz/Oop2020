package ua.reflection1;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TextContainer tc = new TextContainer();
        Class<?> cls =tc.getClass();

        try {
            if (cls.isAnnotationPresent(SaveTo.class)){
                SaveTo saveTo = cls.getAnnotation(SaveTo.class);
                Method[] mtd = cls.getMethods();
                for (Method m: mtd) {
                    if (m.isAnnotationPresent(Saver.class)){
                        m.invoke(tc,saveTo.path());
                    }
                }
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

    }
}
