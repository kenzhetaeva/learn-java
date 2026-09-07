package practice13;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningByDemo {
    public static void main(String[] args) {
        User[] usersArray = {
                new User("Aigerim", 24, true),
                new User("John", 32, true),
                new User("David", 20, false),
                new User("Aidana", 25, false),
                new User("Birzhan", 30, true)
        };
        List<User> users = Arrays.asList(usersArray);

        Map<Boolean, List<String>> result = users.stream()
                .collect(Collectors.partitioningBy(
                        User::isActive,
                        Collectors.mapping(User::getName, Collectors.toList())
                ));

        result.forEach((isActive, names) ->
                System.out.println(isActive + ": " + names)
        );
    }
}
