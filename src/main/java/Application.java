import operations.Operation;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Application {
    public static void main(String[] args) {
        Queue<Operation> operationsQueue = new LinkedList<>();
        Stack<BigDecimal> resultsStack = new Stack<>();
        Calculator calculator = new Calculator();
        Printer printer = new Printer();

        operationsQueue.add(new Operation(2, 3, '+'));
        operationsQueue.add(new Operation(14, 8, '-'));
        operationsQueue.add(new Operation(5,6,'*'));
        operationsQueue.add(new Operation(2147483647, 2, '+'));
        operationsQueue.add(new Operation(18, 3, '/'));
        operationsQueue.add(new Operation(15, 2, '/'));
//        operationsQueue.add(new Operation(10, 0, '/'));

        printer.printRemainingOperations(operationsQueue);

        while(!operationsQueue.isEmpty()){
            Operation operation = operationsQueue.poll();
            System.out.println("\n-> Current operation: "+operation);
            calculator.calculate(operation);
            System.out.print("-> Result: "+operation+"\n");

            resultsStack.add(operation.getResult());

            printer.printRemainingOperations(operationsQueue);
        }

        printer.printStack(resultsStack);
    }
}