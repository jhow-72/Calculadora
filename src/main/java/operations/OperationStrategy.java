package operations;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface OperationStrategy {
    BigDecimal execute(BigInteger valA, BigInteger valB);
}