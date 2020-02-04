package ua.methodreferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MainforEach {
    public static void main(String[] args) {
        //Ссылки на методы позволяют упростить код
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(number -> System.out.println(number));

        //до следующего
        List<Integer> numbers1 = Arrays.asList(11, 22, 31, 14, 35);
        numbers1.forEach(System.out::println);

        //Cобственный метод и лямбда
        Function<String, Integer> toInteger = string -> parse(string);
        Integer integer = toInteger.apply("5");
        System.out.println(integer);

        //Cобственный метод и ссылка на метод
        Function<String, Integer> toInteger1 = MainforEach::parse;
        Integer integer1 = toInteger.apply("5");
        System.out.println(integer);




    }

    private static Integer parse(String s) {
        return Integer.parseInt(s);
    }




}
