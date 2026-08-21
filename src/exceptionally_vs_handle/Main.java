package exceptionally_vs_handle;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
                    if (true) {
                        throw new RuntimeException("Ошибка в supplyAsync!");
                    }
                    return "Успех";
                })
                .exceptionally(ex -> {
                    System.out.println("Перехвачено в exceptionally: " + ex.getMessage());
                    return "Значение-заглушка"; // Возвращаем безопасный результат
                })
                .thenAccept(result -> System.out.println("Результат: " + result));

        CompletableFuture.supplyAsync(() -> {
                    Integer.parseInt("не число"); // Вызовет NumberFormatException
                    return 42;
                })
                .handle((res, ex) -> {
                    if (ex != null) {
                        System.out.println("Перехвачено в handle ошибка: " + ex.getMessage());
                        return 0; // Значение по умолчанию при ошибке
                    }
                    return res * 2; // Действие, если всё прошло успешно
                })
                .thenAccept(result -> System.out.println("Результат handle: " + result));

        // Пауза, чтобы асинхронные задачи успели выполниться
        try { Thread.sleep(500); } catch (InterruptedException e) {}
    }
}

