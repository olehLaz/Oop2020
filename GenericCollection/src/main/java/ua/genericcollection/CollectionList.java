package ua.genericcollection;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class CollectionList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(10);
        list.add(-2);
        //list.add("hello") //ошибка
        System.out.println("---------------");
        Integer[] arr = new Integer[10];
        int c=0;
        for (int i = 0; i <arr.length ; i++) {
            c = i+1;
            arr[i] = c;
        }
        for (int t : arr)
            System.out.print("   " + t);
        System.out.println();
        for (int i = 0; i <arr.length ; i++) {
            System.out.print("   " +arr[i]);
        }
        System.out.println();
        System.out.println(arr);
        System.out.println("--------------------");

        System.out.println(list);
        list.set(2,5);
        System.out.println(list);
        int position = list.indexOf(10);
        System.out.println(position);
        list.add(2,18);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
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
