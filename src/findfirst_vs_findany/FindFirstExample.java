package findfirst_vs_findany;

import java.util.*;

public class FindFirstExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Анна", "Иван", "Алексей", "Ольга");

        Optional<String> firstWithA = names.stream()
                .filter(name -> name.startsWith("А"))
                .findFirst();

        if (firstWithA.isPresent()) {
            System.out.println(firstWithA.get()); // Анна
        } else {
            System.out.println("Элемент не найден");
        }
    }
}
