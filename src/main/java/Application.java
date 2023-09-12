import operations.Operation;

import java.util.LinkedList;
import java.util.Queue;

public class Application {
    public static void main(String[] args) {
        Queue<Operation> operationsQueue = new LinkedList<>();
        Calculator calculator = new Calculator();

        operationsQueue.add(new Operation(2, 3, '+'));
        operationsQueue.add(new Operation(14, 8, '-'));
        operationsQueue.add(new Operation(5,6,'*'));
        operationsQueue.add(new Operation(2147483647, 2, '+'));
        operationsQueue.add(new Operation(18, 3, '/'));
        operationsQueue.add(new Operation(72, 10, '/'));
//        operationsQueue.add(new Operation(10, 0, '/'));

        calculator.calculateOperationsQueue(operationsQueue);
    }
}