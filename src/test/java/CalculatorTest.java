import operations.Operation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

public class CalculatorTest {
    @Test
    public void testAdditionStandard() {
        Calculator calculator = new Calculator();
        Operation operation = new Operation(2, 3, '+');
        BigDecimal expectedValue = new BigDecimal("5");

        calculator.calculateOperation(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testAdditionMaximumIntValue() {
        Calculator calculator = new Calculator();
        Operation operation = new Operation(2147483647, 2, '+');
        BigDecimal expectedValue = new BigDecimal("2147483649");

        calculator.calculateOperation(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testSubtractionStandardValues() {
        Calculator calculator = new Calculator();
        Operation operation = new Operation(14, 8, '-');
        BigDecimal expectedValue = new BigDecimal("6");

        calculator.calculateOperation(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testSubtraction1NegativeValue() {
        Calculator calculator = new Calculator();
        Operation operation = new Operation(14, -9, '-');
        BigDecimal expectedValue = new BigDecimal("23");

        calculator.calculateOperation(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        Operation operation = new Operation(7, -2, '*');
        BigDecimal expectedValue = new BigDecimal("-14");

        calculator.calculateOperation(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testDivisionStandard() {
        Calculator calculator = new Calculator();
        Operation operation = new Operation(10, 5, '/');
        BigDecimal expectedValue = new BigDecimal("2");

        calculator.calculateOperation(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testDivisionNegativeDecimalValue() {
        Calculator calculator = new Calculator();
        Operation operation = new Operation(7, -2, '/');
        BigDecimal expectedValue = new BigDecimal("-3.5");

        calculator.calculateOperation(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        Operation operation = new Operation(10, 0, '/');

        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.calculateOperation(operation)
        );
    }
}