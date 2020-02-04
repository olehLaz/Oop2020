package ua.methodreferences;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MainUser {
    public static void main(String[] args) {
        //Теперь же, вместо реализации интерфейса используем ссылку на конструктор User
        UserFactory userFactory = User::new;
        User user = userFactory.create("John", "Snow");
        System.out.println(user);


        //Function composition
        //Ссылки на методы смотрятся еще лучше при цепочке обращений.
        Function<String, String> trim = String::trim;
        String str = trim
                .andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" ABCDEFG ");
        System.out.println(str);

        //Comparator
        List<User> users = new ArrayList<>();
        users.add(new User("Nick", "Boll"));
        users.add(new User("Jan", "Nicky"));
        users.add(new User("Bot", "Smart"));

        users.sort(Comparator.comparing(User::getName));
        users.forEach(System.out::println);
    }
}
