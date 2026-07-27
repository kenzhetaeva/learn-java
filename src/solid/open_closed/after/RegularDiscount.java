package solid.open_closed.after;

public class RegularDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.05;
    }
}
