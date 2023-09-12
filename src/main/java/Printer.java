import operations.Operation;

import java.util.Queue;
import java.util.Stack;

public class Printer {

    public void printOperation(Operation operation) {
        String valA = operation.getValA().toString();
        String valB = operation.getValB().toString();
        char op = operation.getOperator();
        String r = operation.getResult() == null ? "?" : operation.getResult().toString();

        System.out.printf("%s %c %s = %s%n", valA, op, valB, r);
    }

    public void printRemainingOperations(Queue<Operation> queue) {
        System.out.println("\n****** Remaining Operations: ******");

        if (queue.isEmpty()){
            System.out.println("the queue is empty");
        } else {
            queue.forEach(this::printOperation);
        }
    }

    public void printStack(Stack stack){
        System.out.println("\nAll Results Stack:");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}