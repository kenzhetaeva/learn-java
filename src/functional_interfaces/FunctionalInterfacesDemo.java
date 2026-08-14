package functional_interfaces;

import java.util.function.*;

public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        // Predicate: проверка четности
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // Function: строка в её длину
        Function<String, Integer> stringLength = String::length; // Method reference ClassName::instanceMethod

        // Consumer: печать в консоль
        Consumer<String> printer = System.out::println; // Method reference object::instanceMethod

        // Supplier: создание нового объекта
        Supplier<StringBuilder> builderSupplier = StringBuilder::new; // Constructor reference ClassName::new

        if (isEven.test(4)) {
            printer.accept("Длина слова: " + stringLength.apply("Java"));
        }
    }
}
