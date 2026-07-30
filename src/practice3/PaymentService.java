package practice3;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {

    // Spring автоматически замаппит bean-имя в ключи или можно собрать с помощью Map
    private final Map<String, PaymentStrategy> paymentStrategies;

    public PaymentService(Map<String, PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    public void process(String paymentType, double amount) {
        PaymentStrategy strategy = paymentStrategies.get(paymentType);
        if (strategy == null) {
            throw new IllegalArgumentException("Неподдерживаемый тип оплаты: " + paymentType);
        }
        strategy.processPayment(amount);
    }
}
