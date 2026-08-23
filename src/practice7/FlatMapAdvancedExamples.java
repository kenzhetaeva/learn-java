package practice7;

import java.util.List;
import java.util.Optional;

public class FlatMapAdvancedExamples {

    record Order(String orderId, List<String> items) {}
    record User(String name, Optional<String> middleName) {}

    public static void main(String[] args) {
        // --- Сценарий 1: Список объектов с их внутренними списками ---
        List<Order> orders = List.of(
                new Order("ORD-1", List.of("Laptop", "Mouse")),
                new Order("ORD-2", List.of("Keyboard", "Monitor"))
        );

        // Извлекаем уникальный плоский список всех товаров из всех заказов
        List<String> allItems = orders.stream()
                .flatMap(order -> order.items().stream()) // Превращаем List<String> каждого заказа в Stream<String>
                .distinct()
                .toList();

        System.out.println("Все товары: " + allItems); // [Laptop, Mouse, Keyboard, Monitor]

        // --- Сценарий 2: Optional и flatMap ---
        List<User> users = List.of(
                new User("Aidana", Optional.of("Kanybekovna")),
                new User("John", Optional.empty())
        );

        // Извлекаем только присутствующие middleName без использования isPresent() / get()
        List<String> middleNames = users.stream()
                .map(User::middleName)                      // Stream<Optional<String>>
                .flatMap(Optional::stream)                  // Превращает Optional.of(v) в Stream(v), а Optional.empty() в пустой Stream
                .toList();

        System.out.println("Отчества: " + middleNames); // [Kanybekovna]
    }
}
