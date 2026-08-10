package deadlock;

public class DeadlockFixed {

    private static final Object LockA = new Object();
    private static final Object LockB = new Object();

    public static void main(String[] args) {
        // Поток 1 берет LockA -> ждет LockB
        Thread t1 = new Thread(() -> {
            synchronized (LockA) {
                System.out.println("Thread 1: Захватил LockA");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (LockB) {
                    System.out.println("Thread 1: Захватил LockB");
                }
            }
        });

        // Корректная реализация для второго потока:
        Thread t2Corrected = new Thread(() -> {
            synchronized (LockA) { // Сначала всегда LockA!
                System.out.println("Thread 2: Захватил LockA");
                synchronized (LockB) {
                    System.out.println("Thread 2: Захватил LockB");
                }
            }
        });

        t1.start();
        t2Corrected.start();
    }
}
