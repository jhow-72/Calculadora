package operations;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Multiplication implements OperationStrategy{
    @Override
    public BigDecimal execute(BigInteger valA, BigInteger valB) {
        return new BigDecimal(valA.multiply(valB));
    }
}