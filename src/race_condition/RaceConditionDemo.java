package race_condition;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RaceConditionDemo {

    // --- 1. Непотокобезопасная реализация ---
    static class UnsafeCounter {
        private int count = 0;
        public void increment() {
            count++;
        }
        public int getCount() {
            return count;
        }
    }

    // --- 2. Решение через synchronized (Mutual Exclusion + Visibility) ---
    static class SynchronizedCounter {
        private int count = 0;
        public synchronized void increment() {
            count++; // Синхронизация по this
        }
        public synchronized int getCount() {
            return count;
        }
    }

    // --- 3. Решение через AtomicInteger (Lock-Free / CAS) ---
    static class AtomicCounter {
        private final AtomicInteger count = new AtomicInteger(0);
        public void increment() {
            count.incrementAndGet(); // На основе CAS
        }
        public int getCount() {
            return count.get();
        }
    }

    // --- 4. Решение через ReentrantLock ---
    static class LockCounter {
        private int count = 0;
        private final Lock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            try {
                count++;
            } finally {
                lock.unlock(); // Гарантированное освобождение в finally
            }
        }
        public int getCount() {
            return count;
        }
    }
}
