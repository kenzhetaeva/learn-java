package optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> activeUser = Optional.of("Aidana");

        System.out.println("--- Вызов orElse ---");
        // getHardcodedDefault() вызовется ДАЖЕ ЕСЛИ activeUser присутствовал!
        String name1 = activeUser.orElse(getHardcodedDefault());

        System.out.println("\n--- Вызов orElseGet ---");
        // Supplier выполнится ТОЛЬКО если Optional.empty()
        String name2 = activeUser.orElseGet(() -> getHardcodedDefault());
    }

    private static String getHardcodedDefault() {
        System.out.println("LOG: Тяжелый вызов метода получения значения по умолчанию!");
        return "Default_User";
    }
}
