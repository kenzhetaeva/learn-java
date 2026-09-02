package practice10;

import java.util.List;

public class FlatMapDemo {
    public static void main(String[] args) {
        List<List<String>> names = List.of(
                List.of("Anthony", "Becky"),
                List.of("Chris", "David")
        );
        System.out.println(names.stream().flatMap(List::stream).toList());

        List<Integer> lengths = names.stream()
                .flatMap(List::stream)
                .map(String::length)
                .toList();

        System.out.println(lengths);
    }
}
