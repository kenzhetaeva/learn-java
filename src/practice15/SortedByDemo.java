package practice15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortedByDemo {
    public static void main(String[] args) {
        User[] usersArray = {
                new User("Aigerim", 24, true),
                new User("John", 32, true),
                new User("David", 20, false),
                new User("Aidana", 25, false),
                new User("Birzhan", 30, true)
        };
        List<User> users = Arrays.asList(usersArray);

        List<User> result = users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .toList();

        result.forEach(user -> System.out.println(user.getName() + " - " + user.getAge()));

        System.out.println("-------------");

        result = users.stream()
                .sorted(Comparator.comparing(User::getAge).reversed())
                .toList();

        result.forEach(user -> System.out.println(user.getName() + " - " + user.getAge()));
    }
}
