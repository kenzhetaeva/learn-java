package solid.open_closed.after;

public class VipDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price * 0.20;
    }
}
