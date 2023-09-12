package operations;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Division implements OperationStrategy{
    @Override
    public BigDecimal execute(BigInteger valA, BigInteger valB) {
        BigDecimal bigDecimalA = new BigDecimal(valA);
        BigDecimal bigDecimalB = new BigDecimal(valB);

        return bigDecimalA.divide(bigDecimalB);
    }
}