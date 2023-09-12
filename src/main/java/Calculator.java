import operations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Queue;
import java.util.Stack;

public class Calculator {
    private static Logger logger = LogManager.getLogger(Calculator.class);

    public Operation calculateOperation(Operation operation) {
        OperationStrategy strategy = defineStrategy(operation.getOperator());

        if (strategy != null) {
            calculateOperationBasedOnStrategy(operation, strategy);
        }
        else {
            logger.warn("couldn't determine the operation strategy - setting the result to 0");
            operation.setResult(BigDecimal.ZERO);
        }
        return operation;
    }

    private static void calculateOperationBasedOnStrategy(Operation operation, OperationStrategy strategy) {
        try {
            operation.setResult(strategy.execute(operation.getValA(), operation.getValB()));
        }
        catch (ArithmeticException e) {
            throw e;
        }
        catch (Exception e) {
            logger.error("Unexpected error while trying to execute the operation - " + e.getMessage());
            throw new RuntimeException("Error while executing operation", e);
        }
    }

    private OperationStrategy defineStrategy(char operator) {
        return switch (operator) {
            case '+' -> new Addition();
            case '-' -> new Subtraction();
            case '*' -> new Multiplication();
            case '/' -> new Division();
            default -> null;
        };
    }

    public void calculateOperationsQueue(Queue<Operation> operationsQueue) {
        Stack<BigDecimal> resultsStack = new Stack<>();
        Printer printer = new Printer();

        printer.printRemainingOperations(operationsQueue);

        while(!operationsQueue.isEmpty()){
            Operation operation = operationsQueue.poll(); // retorna e remove a proxima operacao da fila
            System.out.println("\n-> Current operation: "+operation);

            this.calculateOperation(operation);
            System.out.print("-> Result: "+operation+"\n");
            printer.printRemainingOperations(operationsQueue);

            resultsStack.add(operation.getResult()); // adiciona apenas os resultados para serem impressos posteriormente
        }

        printer.printStack(resultsStack);
    }
}