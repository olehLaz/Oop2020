package ua.reflectionrectangle;


public class Rectangle {
    @MyAnnotation(sizeA = 5, sizeB = 43)
    public static int square(int sizeA, int sizeB) {
        int s = sizeA * sizeB;
        return s;

    }
}
