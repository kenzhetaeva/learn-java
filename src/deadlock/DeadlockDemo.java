package deadlock;

public class DeadlockDemo {

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

        // Поток 2 берет LockB -> ждет LockA
        Thread t2 = new Thread(() -> {
            synchronized (LockB) {
                System.out.println("Thread 2: Захватил LockB");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (LockA) {
                    System.out.println("Thread 2: Захватил LockA");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
