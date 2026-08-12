package start_vs_run;

public class StartExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("Выполняется в потоке: " + Thread.currentThread().getName());
        });

        // Создает новый поток с именем (например, Thread-0)
        thread.start();

        System.out.println("Выполняется в потоке: " + Thread.currentThread().getName());
    }
}
