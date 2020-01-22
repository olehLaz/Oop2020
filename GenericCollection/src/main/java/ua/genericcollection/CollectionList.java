package ua.genericcollection;

import java.sql.Array;
import java.util.*;

public class CollectionList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(10);
        list.add(-2);
        System.out.println(list.toString());
        list.set(2,5);
        System.out.println(list.toString());
        int position = list.indexOf(10);
        System.out.println(position);
        list.add(2,18);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        Iterator<Integer> itr = list.iterator();
        for(;itr.hasNext();){
            System.out.println(itr.next());
        }
        for(Integer integer: list)
            System.out.println(integer);

        Collections.sort(list);
        System.out.println(list);


    }
}
