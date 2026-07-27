package solid.open_closed.before;

public class DiscountCalculator {
    public double calculateDiscount(String customerType, double price) {
        if ("REGULAR".equals(customerType)) {
            return price * 0.05;
        } else if ("VIP".equals(customerType)) {
            return price * 0.20;
        } else if ("PREMIUM".equals(customerType)) {
            return price * 0.30;
        }

        return 0;
    }
}
