package start_vs_run;

public class RunExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Выполняется в потоке: " + Thread.currentThread().getName());
        });

        // Прямой вызов run() — НЕ создает новый поток
        thread.run();

        System.out.println("Выполняется в потоке: " + Thread.currentThread().getName());
    }
}
