package ua.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Vaska", 2, "White");
        Cat cat2 = new Cat("Murka", 3, "Red");
        Cat cat3 = new Cat("Bonifaci", 5, "Black");
        Cat cat4 = new Cat("Kuza", 1, "Gray");
        Cat cat5 = new Cat("Umka", 7, "Black & White");

        ArrayList<Cat> catList = new ArrayList<>();

        catList.add(cat1);
        catList.add(cat2);
        catList.add(cat3);
        catList.add(cat4);
        catList.add(cat5);
     //   printList(catList);

        //Predicate<T>
        System.out.println("-----Predicate<T>-----");
        ArrayList<Cat> listOne = catList.stream()
               .filter(b -> b.getName() != "Bonifaci")  //b это кот
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(listOne);

        ArrayList<Cat> listTwo = catList.stream()
                .filter(c -> c.getAge()>3)   //c это кот
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(listTwo);
        System.out.println("-------------------------");

        //Интерфейс Function<T, R> и использование в методах map()

        System.out.println("---Интерфейс Function<T, R> --------");
        ArrayList<String> listThree = catList.stream()
                .filter(d -> d.getAge()>3)
                .map(n -> n.getName()) //преобразование котов в их имена
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(listThree);
        System.out.println("-------------------------");

        System.out.println("---Интерфейс Comparator<T, T>  и его  использование в sort()--------");
        ArrayList<String> listFour = catList.stream()
                .filter(d -> d.getAge()>3)
                .sorted((f,d) -> f.getName().length() - d.getName().length())
                .map(n -> n.getName()) //преобразование котов в их имена
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(listFour);
        System.out.println("-------------------------");


    }
    public static void printList(List<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
