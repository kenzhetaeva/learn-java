package practice3;

import org.springframework.stereotype.Component;

@Component("CARD")
public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата картой: " + amount);
    }

    @Override
    public String getType() {
        return "CARD";
    }
}
