package practice4;

import java.math.BigDecimal;

public class MastercardCommission implements CommissionStrategy {
    public BigDecimal calculate(BigDecimal amount) {
        return amount.multiply(new BigDecimal("0.03"));
    }
}
