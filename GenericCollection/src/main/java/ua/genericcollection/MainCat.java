package ua.genericcollection;

import java.util.LinkedList;

public class MainCat {
    public static void main(String[] args) {
        System.out.println("-------Cat---------------");
        GroupCat groupCat = SaveAndLoadToFile.loadFromFile("c:\\Act\\Prog\\2020\\Core\\Oop2020\\cat.txt");

        LinkedList<Cat> linkedList = new LinkedList<>();
        linkedList.addAll(groupCat, (a, b) -> (a.) );

        System.out.println(groupCat);

        SaveAndLoadToFile.saveToFile(groupCat);

    }
}
