package thread_pool_executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Создаем пул потоков
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2, // core pool size
                4, // max pool size
                10, TimeUnit.SECONDS, // время жизни лишних потоков
                new ArrayBlockingQueue<>(2) // очередь задач
        );

        // Отправляем задачи на выполнение
        for (int i = 1; i <= 6; i++) {
            final int taskId = i;
            threadPoolExecutor.execute(() -> {
                System.out.println("Задача " + taskId + " выполняется в " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        // Завершаем работу пула
        threadPoolExecutor.shutdown();
    }
}
