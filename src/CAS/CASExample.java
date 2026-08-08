package CAS;

import java.util.concurrent.atomic.AtomicReference;

public class CASExample {
    public static void main(String[] args) {
        AtomicReference<String> state = new AtomicReference<>("STATE_A");

        // Успешная замена: ожидалось STATE_A, меняем на STATE_B
        boolean updated = state.compareAndSet("STATE_A", "STATE_B");
        System.out.println("Обновлено: " + updated + ", текущее состояние: " + state.get()); // true, STATE_B

        // Неудачная замена: ожидалось STATE_A, но актуальное состояние - STATE_B
        boolean failedUpdate = state.compareAndSet("STATE_A", "STATE_C");
        System.out.println("Обновлено: " + failedUpdate + ", текущее состояние: " + state.get()); // false, STATE_B
    }
}
