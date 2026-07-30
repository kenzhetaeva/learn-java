package practice3;

import org.springframework.stereotype.Component;

@Component("PAYPAL")
public class PaypalPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Оплата через PayPal: " + amount);
    }

    @Override
    public String getType() {
        return "PAYPAL";
    }
}
