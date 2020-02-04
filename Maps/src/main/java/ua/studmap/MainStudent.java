package ua.studmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainStudent {
    public static void main(String[] args) {
        HashMap<String, Student> hm = new HashMap<String, Student>();
        hm.put("Petrov", new Student("Petrov Petr Petrovich", "physics",2,9.8));
        hm.put("Sidorov", new Student("Sidorov Sidr Sidorovich", "physics",1,10.0));
        hm.put("Ivanov", new Student("Ivanov Ivan Ivanovich", "geogragy",5,7.0));

        System.out.println(hm.get("Petrov"));
        System.out.println();
        Set<Map.Entry<String, Student>> hms = hm.entrySet();
        for (Map.Entry<String, Student> hmse : hms) {
            System.out.println(hmse.getKey() + '\t' + hmse.getValue());
        }
        //Для набора Set можно объявить итератор
        Iterator<Map.Entry<String, Student>> itr = hm.entrySet().iterator();
        for(;itr.hasNext();){
            System.out.println(itr.next());
        }
        //Также можно получить набор ключей
        Set<String> set = hm.keySet();
        for (String str : set) {
            System.out.println(str);
        }


    }
}
