package reduce;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = List.of("Java", "Core", "Stream");

        String result = words.stream()
                .reduce("", (a, b) -> a.isEmpty() ? b : a + ", " + b);

        System.out.println(result); // Java, Core, Stream
    }
}
