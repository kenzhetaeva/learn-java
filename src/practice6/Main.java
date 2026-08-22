package practice6;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        /*
        Stream<String> stream = Stream.of("яблоко", "банан", "апельсин");

        long count = stream.count(); // Первая терминальная операция — всё работает
        // Ошибка IllegalStateException, так как поток уже закрыт:
        List<String> list = stream.toList();
        */

        List<String> source = List.of("яблоко", "банан", "апельсин");

        long count = source.stream().count(); // Создаем и используем первый стрим
        List<String> list = source.stream().toList(); // Создаем новый стрим для второй операции

        System.out.println(count);
        System.out.println(list);
    }
}
