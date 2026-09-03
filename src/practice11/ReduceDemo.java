package practice11;

import java.util.List;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        System.out.println(sum);
    }
}
