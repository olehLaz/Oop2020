package ua.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Collectors;

public class Maintxt {
    public static void main(String[] args) {
        try {
            Files.lines(Paths.get("general.txt")) //stream из файла
                    .map(n -> n.toUpperCase()) // в верхний регистр
                    .flatMapToInt(n -> n.chars()) //Каждую строку в отдельный поток
                    .filter(k -> k >= 'A' && k <= 'Z') // что символ это буква
                    .mapToObj((m) -> (Character.valueOf((char) m)))
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                    .entrySet().stream()
                    .sorted((v,w) -> (int) (w.getValue() - v.getValue()))
                    .forEach(r -> System.out.println(r));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
