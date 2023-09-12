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

    // valA e valB sao retornados como BigInteger para podermos fazer operacoes como: 2147483647 + 2
    public BigInteger getValA() {
        return new BigInteger(String.valueOf(valA));
    }

    public BigInteger getValB() {
        return new BigInteger(String.valueOf(valB));
    }

    @Override
    public String toString() {
        String r = result==null ? "X" : result.toString();
        return String.format("%s %c %s = %s",valA, operator, valB, r);
    }
}