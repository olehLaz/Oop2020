package ua.comparable1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

public class MainCat {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Cat[] cats = new Cat[]{
                new Cat("Kuza",1,"Gray",true),
                new Cat("Vaska",2,"White",true),
                new Cat("Murka",3,"Red",true),
                new Cat("Bonifaci",5,"Black",false),
                new Cat("Umka",7,"Black & White",false)
        };

        System.out.println("------------Cat::getAge------------------------");
        Arrays.sort(cats, Comparator.comparing(Cat::getAge,  (a, b) -> {
                return a.compareTo(b);
                }
        ));
        for (int i = 0; i <cats.length ; i++) {
            System.out.println(cats[i]);
        }
        System.out.println("------------Cat::getName------------------------");
        Arrays.sort(cats, Comparator.comparing(Cat::getName,  (a, b) -> {
                    return a.compareTo(b);
                }
        ));
        for (int i = 0; i <cats.length ; i++) {
            System.out.println(cats[i]);
        }

        System.out.println("------------Cat::getColor------------------------");
        Arrays.sort(cats, Comparator.comparing(Cat::getColor,  (a, b) -> {
                    return a.compareTo(b);
                }
        ));
        for (int i = 0; i <cats.length ; i++) {
            System.out.println(cats[i]);
        }
        System.out.println("------------Cat::isSex------------------------");
        Arrays.sort(cats, Comparator.comparing(Cat::isSex,  (a, b) -> {
                    return a.compareTo(b);
                }
        ));
        for (int i = 0; i <cats.length ; i++) {
            System.out.println(cats[i]);
        }

    }

}
