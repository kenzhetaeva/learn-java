package practice4;

import java.math.BigDecimal;

public interface CommissionStrategy {
    BigDecimal calculate(BigDecimal amount);
}
