package ua.genericcollection;

import java.io.File;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SomeClass<Integer> someC = new SomeClass<>(1234);
        //someC.setObj("123854"); //ошибка
        someC.setObj(785);
        System.out.println(someC);

        SomeClass<String> someTwo = new SomeClass<>("Hello");
        someTwo.setObj("reports");
        System.out.println(someTwo);
        SomeClass someThree = new SomeClass(new File("1.txt")); //обратная совместимость


        SomeClassNumber<BigInteger> someFive = new SomeClassNumber<>(new BigInteger("85444444552211211"));
        System.out.println(someFive.getObj());


        Operation<Double, BigInteger> operation = new Operation<>(145.45, new BigInteger("454542"));
        System.out.println(operation.sum());
        Integer[] arrayOne = new Integer[]{100,41,78,52,56,4};
        int min = findMin(arrayOne);
        System.out.println(min);
        String[] arrayTwo = new String[]{"hello", "gonna", "gotta", "depency", "Album"};
        String minstr = findMin(arrayTwo);
        System.out.println(" min =  " + minstr);

        Arrays.sort(arrayTwo,
                (a,b) -> a.compareTo(b));
        System.out.println(" sorted = " + '\n');
        for (String s : arrayTwo)
        System.out.println(s);

    }
    public static <T extends Comparable<T>> T findMin(T[] array) {
        T min = array[0];
        for (T element : array) {
            if(min.compareTo(element) > 0)
                min = element;
        }
        return min;

    }

}
