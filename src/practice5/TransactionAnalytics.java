package practice5;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionAnalytics {

    public enum Status { SUCCESS, FAILED, PENDING }

    public record Transaction(
            String id,
            String userId,
            BigDecimal amount,
            String currency,
            Status status,
            LocalDateTime createdAt
    ) {}

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction("1", "userA", new BigDecimal("100.00"), "USD", Status.SUCCESS, LocalDateTime.now().minusHours(5)),
                new Transaction("2", "userB", new BigDecimal("250.50"), "EUR", Status.SUCCESS, LocalDateTime.now().minusHours(3)),
                new Transaction("3", "userA", new BigDecimal("500.00"), "USD", Status.SUCCESS, LocalDateTime.now().minusHours(1)),
                new Transaction("4", "userC", new BigDecimal("50.00"),  "USD", Status.FAILED,  LocalDateTime.now().minusMinutes(10)),
                new Transaction("5", "userB", new BigDecimal("300.00"), "EUR", Status.SUCCESS, LocalDateTime.now())
        );

        // 1. Получить только успешные транзакции
        List<Transaction> successfulTx = transactions.stream()
                .filter(tx -> tx.status() == Status.SUCCESS)
                .toList();

        // 2. Общая сумма успешных транзакций (через BigDecimal reduce)
        BigDecimal totalAmount = transactions.stream()
                .filter(tx -> tx.status() == Status.SUCCESS)
                .map(Transaction::amount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 3. Сумма успешных транзакций по каждому пользователю
        Map<String, BigDecimal> totalByUser = transactions.stream()
                .filter(tx -> tx.status() == Status.SUCCESS)
                .collect(Collectors.groupingBy(
                        Transaction::userId,
                        Collectors.reducing(BigDecimal.ZERO, Transaction::amount, BigDecimal::add)
                ));

        // 4. Сумма транзакций по каждой валюте
        Map<String, BigDecimal> totalByCurrency = transactions.stream()
                .filter(tx -> tx.status() == Status.SUCCESS)
                .collect(Collectors.groupingBy(
                        Transaction::currency,
                        Collectors.reducing(BigDecimal.ZERO, Transaction::amount, BigDecimal::add)
                ));

        // 5. Найти пользователя с максимальным оборотом
        Optional<String> topUser = totalByUser.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

        // 6. Получить последние 10 транзакций, отсортированных по createdAt (от свежих к старым)
        List<Transaction> last10Transactions = transactions.stream()
                .sorted(Comparator.comparing(Transaction::createdAt).reversed())
                .limit(10)
                .toList();

        // Вывод результатов
        System.out.println("Total Amount: " + totalAmount);
        System.out.println("Total by User: " + totalByUser);
        System.out.println("Top User: " + topUser.orElse("N/A"));
    }
}
