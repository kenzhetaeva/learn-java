package practice9;

import java.util.List;

public class FilterDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 3, 34, 5, 23, 45, 3, 4, 7, 89, 33);

        List<Integer> result = numbers.stream()
                        .filter(n -> n > 10)
                        .toList();

        System.out.println(result);
    }
}
