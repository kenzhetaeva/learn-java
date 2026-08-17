package completable_future;

import java.util.concurrent.CompletableFuture;

public class CompletableFuturePipeline {
    public static void main(String[] args) throws Exception {

        // 1. thenCompose (Зависимые задачи): Сначала ищем User, затем запрашиваем его баланс
        CompletableFuture<Double> userBalanceFuture = fetchUserId("usr_100")
                .thenCompose(userId -> fetchBalanceByUserId(userId)); // T -> CompletableFuture<R>

        // 2. thenCombine (Параллельные независимые задачи): Получаем курсы BTC и ETH одновременно
        CompletableFuture<Double> btcPrice = CompletableFuture.supplyAsync(() -> 60000.0);
        CompletableFuture<Double> ethPrice = CompletableFuture.supplyAsync(() -> 3000.0);

        CompletableFuture<Double> totalPrice = btcPrice.thenCombine(ethPrice, (btc, eth) -> btc + eth);

        System.out.println("Total portfolio price: " + totalPrice.get());
    }

    private static CompletableFuture<String> fetchUserId(String token) {
        return CompletableFuture.supplyAsync(() -> "ID_9982");
    }

    private static CompletableFuture<Double> fetchBalanceByUserId(String userId) {
        return CompletableFuture.supplyAsync(() -> 1550.50);
    }
}
