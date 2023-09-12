package operations;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Operation {
    private final char operator;
    private final int valA;
    private final int valB;
    private BigDecimal result;

    public Operation(int valA, int valB, char operator){
        this.valA = valA;
        this.valB = valB;
        this.operator = operator;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public char getOperator() {
        return operator;
    }

    public BigInteger getValA() {
        return new BigInteger(String.valueOf(valA));
    }

    public BigInteger getValB() {
        return new BigInteger(String.valueOf(valB));
    }
}