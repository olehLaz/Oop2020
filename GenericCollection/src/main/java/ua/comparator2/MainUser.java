package ua.comparator2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainUser {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("John","Sheldon", 36),
                new User("Jane","Wathson", 35),
                new User("Alex","Miller", 21));

        System.out.println(" Before sorting ... ");
        for (User user : users) {
            System.out.println(user);
        }
        //анонимный класс
        Collections.sort(users, new NewUserComparator(){
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getAge() - o2.getAge();
                    }
                }
        );
        System.out.println("\nAfter sort:");
        for (User user : users) {
            System.out.println(user);
        }

        //лямбда
        Collections.sort(users, (a,b) -> a.getSurname().compareTo(b.getSurname()));
        System.out.println("\nAfter sort:");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("\nAfter sort lambda :");
        for (User user : users) {
            System.out.println(user);
        }

        //В Java 8 в интерфейс List добавили метод sort, что позволяет использовать вместо
    //      Collections.sort(users, (o1, o2) -> o1.getAge() - o2.getAge());
    //    следующее выражение
    //    users.sort((o1, o2) -> o1.getAge() - o2.getAge());

        users.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        System.out.println("\nAfter sort lambda2 :");
        for (User user : users) {
            System.out.println(user);
        }

        Comparator<User> comparator = (o1, o2) -> o1.getAge() - o2.getAge();
        users.sort(comparator.reversed());

        System.out.println("\nAfter sort reversed Age:");
        for (User user : users) {
            System.out.println(user);
        }
        //Сортировка с несколькими условиями
        //До Java 8:
  //      Collections.sort(users, new Comparator<User>() {
   //         @Override
   //         public int compare(User o1, User o2) {
  //              if (o1.getAge() == o2.getAge())
  //                  return o1.getName().compareTo(o2.getName());
  //              else return o1.getAge() - o2.getAge();
  //          }
  //      });
        //Сейчас:
        users.sort((o1, o2) -> {
            if (o1.getAge() == o2.getAge())
                return o1.getName().compareTo(o2.getName());
            else return o1.getAge() - o2.getAge();
        });
        System.out.println("\nAfter sort  Age, name :");
        for (User user : users) {
            System.out.println(user);
        }



    }


}
