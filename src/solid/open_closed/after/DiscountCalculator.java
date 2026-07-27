package solid.open_closed.after;

public class DiscountCalculator {
    public double calculate(DiscountStrategy strategy, double price) {
        return strategy.applyDiscount(price);
    }
}
