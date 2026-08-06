package practice4;

import java.math.BigDecimal;

public class VisaCommission implements CommissionStrategy {
    public BigDecimal calculate(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.02"));
    }
}
