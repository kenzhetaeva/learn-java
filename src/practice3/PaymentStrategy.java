package practice3;

public interface PaymentStrategy {
    void processPayment(double amount);
    String getType(); // "CARD", "PAYPAL", "CRYPTO"
}
