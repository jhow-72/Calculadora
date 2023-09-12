package operations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Division implements OperationStrategy{
    private static final Logger logger = LogManager.getLogger(Division.class);

    @Override
    public BigDecimal execute(BigInteger valA, BigInteger valB) {
        // necessario para retornar valores com casa decimal
        BigDecimal bigDecimalA = new BigDecimal(valA);
        BigDecimal bigDecimalB = new BigDecimal(valB);

        try {
            return bigDecimalA.divide(bigDecimalB);
        } catch (ArithmeticException e){
            logger.error("Check your inputs for the division operation - " + e.getMessage());
            throw new ArithmeticException();
        }
    }
}