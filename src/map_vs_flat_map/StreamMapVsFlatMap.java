package map_vs_flat_map;

import java.util.List;
import java.util.stream.Stream;

public class StreamMapVsFlatMap {
    public static void main(String[] args) {
        List<List<String>> nestedList = List.of(
                List.of("BTC", "ETH"),
                List.of("USDT", "SOL")
        );

        // map() вернет Stream<Stream<String>>
        List<Stream<String>> mapped = nestedList.stream()
                .map(List::stream)
                .toList();

        // flatMap() "расплющивает" до Stream<String>
        List<String> flatMapped = nestedList.stream()
                .flatMap(List::stream) // T -> Stream<R>
                .toList();

        System.out.println(flatMapped); // [BTC, ETH, USDT, SOL]
    }
}
