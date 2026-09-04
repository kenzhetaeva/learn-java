package practice12;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByDemo {
    public static void main(String[] args) {
        User[] usersArray = {
                new User("Aigerim", 24, "Kyrgyzstan"),
                new User("John", 32, "USA"),
                new User("David", 20, "USA"),
                new User("Aidana", 25, "Kyrgyzstan"),
                new User("Birzhan", 30, "Kazakhstan")
        };
        List<User> users = Arrays.asList(usersArray);

        Map<String, List<String>> result = users.stream()
                .collect(Collectors.groupingBy(
                        User::getCountry,
                        Collectors.mapping(User::getName, Collectors.toList())
                ));

        result.forEach((country, names) ->
                System.out.println(country + ": " + names)
        );
    }
}
