package ua.genericcollection;

import java.util.*;

public class MainCat {
    public static void main(String[] args) {
        System.out.println("-------Cat---------------");
        GroupCat groupCat = SaveAndLoadToFile.loadFromFile("c:\\Act\\Prog\\2020\\Core\\Oop2020\\cat.txt");
        List<Cat> list = groupCat.getCats();

        Comparator<Cat> byName = Comparator.comparing(Cat::getName,
                (a,b) -> a.compareTo(b));
        Comparator<Cat> byAge = Comparator.comparing(Cat::getAge,
                (a,b) -> a.compareTo(b));

        list.sort(byAge);
        for (Cat cat1 : list)
            System.out.println(cat1);
        System.out.println("---------------------");
        list.sort(byName);
        for (Cat cat2 : list)
            System.out.println(cat2);



        //   SaveAndLoadToFile.saveToFile(groupCat);

    }
}
