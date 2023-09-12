import operations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Calculator {
    private static Logger logger = LogManager.getLogger(Calculator.class);

    public Operation calculate(Operation operation){
        OperationStrategy strategy;

        switch (operation.getOperator()){
            case '+': strategy = new Addition(); break;
            case '-': strategy = new Subtraction(); break;
            case '*': strategy = new Multiplication(); break;
            case '/': strategy = new Division(); break;
            default: strategy= null; break;
        }

        if (strategy != null) {
            operation.setResult(
                    strategy.execute(operation.getValA(), operation.getValB())
            );
        }
        else {
            logger.warn("couldn't determine the operation strategy - setting the result to 0");
            operation.setResult(BigDecimal.ZERO);
        }

        return operation;
    }
}