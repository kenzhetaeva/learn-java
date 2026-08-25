package completable_future_2;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureAdvancedDemo {

    public static void main(String[] args) throws Exception {

        // Симуляция обращения к внешнему сервису, которое может упасть с ошибкой
        CompletableFuture<String> paymentResult = CompletableFuture.supplyAsync(() -> {
            if (Math.random() < 0.99) { // Эмуляция сбоя
                throw new RuntimeException("Payment Gateway Timeout!");
            }
            return "SUCCESS_TX_9901";
        });

        // Цепочка с фолбеком при ошибке
        CompletableFuture<String> handledPipeline = paymentResult
                // exceptionally() перехватывает ошибку и возвращает дефолтное значение[cite: 5]
                .exceptionally(ex -> {
                    System.err.println("Ошибка платежа: " + ex.getMessage());
                    return "FAILED_FALLBACK_STATUS";
                })
                // thenApply преобразует итоговую строку в верхний регистр[cite: 5]
                .thenApply(String::toLowerCase);

        System.out.println("Итоговый статус: " + handledPipeline.get());
    }
}
