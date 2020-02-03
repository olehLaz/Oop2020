package ua.genericcollection;

import javax.swing.*;
import java.util.*;

public class CollectionSet {
    public static void main(String[] args) {
        //Set и SortedSet интерфейсы
        Set<Integer> listSet = new HashSet<>();
        listSet.add(10);
        listSet.add(-11);
        listSet.add(0);
        listSet.add(6);
        listSet.add(-6);
        listSet.add(7);
        listSet.add(88);
        listSet.add(71);
        listSet.add(15);
        listSet.add(8);
        System.out.println(listSet);


        System.out.println("------LinkedHashSet-------");
        //сохраняет порядок добавления
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(10);
        linkedHashSet.add(-11);
        linkedHashSet.add(0);
        linkedHashSet.add(6);
        linkedHashSet.add(-6);
        linkedHashSet.add(7);
        linkedHashSet.add(88);
        linkedHashSet.add(71);
        linkedHashSet.add(15);
        linkedHashSet.add(8);
        System.out.println(linkedHashSet);




        System.out.println("--------SortedSet---------");
        SortedSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.addAll(listSet);
        System.out.println(sortedSet);
        sortedSet.add(55);
        System.out.println(sortedSet);

        System.out.println(sortedSet.first());
        System.out.println(sortedSet.last());
        System.out.println(sortedSet.headSet(7));
        System.out.println(sortedSet.tailSet(6));
        System.out.println(sortedSet.subSet(6, 71));

        System.out.println("------NavigableSet-------");
        NavigableSet<Integer> navigableSet = new TreeSet<>();
        navigableSet.addAll(listSet);
        System.out.println(navigableSet);

        navigableSet.add(56);
        System.out.println(navigableSet);

        System.out.println(navigableSet.ceiling(8));
        System.out.println(navigableSet.floor(8));
        System.out.println(navigableSet.higher(8));
        System.out.println(navigableSet.lower(8));
        System.out.println(navigableSet.pollFirst());
        System.out.println(navigableSet);
        System.out.println(navigableSet.pollLast());
        System.out.println(navigableSet);
        System.out.println(navigableSet.headSet(10));
        System.out.println(navigableSet.subSet(8, 9999 ));






    }
}
