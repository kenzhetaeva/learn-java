package practice8;

import java.util.List;

public class MapDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Aidana", "Jane", "David", "Jason");

        List<Integer> lengths = names.stream()
                .map(String::length)
                .toList();

        System.out.println(lengths);
    }
}
