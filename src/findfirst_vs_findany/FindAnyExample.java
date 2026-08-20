package findfirst_vs_findany;

import java.util.*;

public class FindAnyExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Анна", "Иван", "Борис", "Игнат");

        Optional<String> result = names.stream()
                .filter(name -> name.startsWith("И"))
                .findAny();

        if (result.isPresent()) {
            System.out.println("Найден элемент: " + result.get());
        } else {
            System.out.println("Элемент не найден");
        }
    }
}
