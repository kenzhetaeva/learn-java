package practice14;

import java.util.List;

public class DistinctDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 2, 3, 6, 6, 4, 7, 5, 6, 7, 8, 9, 1, 2);

        List<Integer> result = numbers.stream()
                .distinct()
                .toList();

        System.out.println(result);
    }
}
