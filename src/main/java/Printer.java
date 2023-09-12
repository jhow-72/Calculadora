import operations.Operation;

import java.util.Queue;
import java.util.Stack;

public class Printer {
    public void printRemainingOperations(Queue<Operation> queue) {
        System.out.println("\n****** Remaining Operations: ******");

        if (queue.isEmpty()){
            System.out.println("the queue is empty");
        } else {
            queue.forEach(System.out::println);
        }
    }

    public void printStack(Stack stack){
        System.out.println("\nAll Results Stack:");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}