package ua.streamapi;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.stream.Collectors;

public class Maintxt {
    public static void main(String[] args) {
        File file = new File("general.txt");
        try {
            Files.lines(Paths.get(file.getAbsolutePath())) //stream из файла
                    .map(n -> n.toUpperCase()) // в верхний регистр
                    .flatMapToInt(n -> n.chars()) //Каждую строку в отдельный поток char-ов
                    .filter(k -> k >= 'A' && k <= 'Z') // что символ это буква
                    .mapToObj((m) -> (Character.valueOf((char) m)))
                    .collect(Collectors.groupingBy(s -> s, Collectors.counting())).entrySet().stream() //карта
                    .sorted((v,w) -> (int) (w.getValue() - v.getValue()))
                    .forEach(r -> System.out.println(r));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
