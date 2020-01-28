package ua.genericcollection;

import java.util.*;

public class MainCat {
    public static void main(String[] args) {
        System.out.println("-------Cat---------------");
        GroupCat groupCat = SaveAndLoadToFile.loadFromFile("c:\\Act\\Prog\\2020\\Core\\Oop2020\\cat.txt");
        List<Cat> list = groupCat.getCats();

        Comparator<Cat> byName = Comparator.comparing(Cat::getName);
        Comparator<Cat> byAge = Comparator.comparing(Cat::getAge);

        list.sort(byAge);
        System.out.println(list);

        list.sort(byName);
        System.out.println(list);



        //   SaveAndLoadToFile.saveToFile(groupCat);

    }
}
