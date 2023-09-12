import operations.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdditionStandard() {
        Calculator calculator = new Calculator();
        Operation operation = new Operation(2, 3, '+');
        BigDecimal expectedValue = new BigDecimal("5");

        calculator.calculate(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testAdditionMaximumIntValue() {
        Operation operation = new Operation(2147483647, 2, '+');
        BigDecimal expectedValue = new BigDecimal("2147483649");

        calculator.calculate(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testSubtractionStandardValues() {
        Operation operation = new Operation(14, 8, '-');
        BigDecimal expectedValue = new BigDecimal("6");

        calculator.calculate(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testSubtraction1NegativeValue() {
        Operation operation = new Operation(14, -9, '-');
        BigDecimal expectedValue = new BigDecimal("23");

        calculator.calculate(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testMultiplication() {
        Operation operation = new Operation(7, -2, '*');
        BigDecimal expectedValue = new BigDecimal("-14");

        calculator.calculate(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testDivisionStandard() {
        Operation operation = new Operation(10, 5, '/');
        BigDecimal expectedValue = new BigDecimal("2");

        calculator.calculate(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testDivisionNegativeDecimalValue() {
        Operation operation = new Operation(7, -2, '/');
        BigDecimal expectedValue = new BigDecimal("-3.5");

        calculator.calculate(operation);
        assertEquals(expectedValue, operation.getResult());
    }

    @Test
    public void testDivisionByZero() {
        Operation operation = new Operation(10, 0, '/');

        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.calculate(operation)
        );
    }
}