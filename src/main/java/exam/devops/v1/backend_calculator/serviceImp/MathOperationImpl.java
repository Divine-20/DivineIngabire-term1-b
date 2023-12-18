package exam.devops.v1.backend_calculator.serviceImp;

import exam.devops.v1.backend_calculator.exceptions.InvalidOperationException;
import exam.devops.v1.backend_calculator.service.IMathOperation;
import org.springframework.stereotype.Service;

@Service
public class MathOperationImpl implements IMathOperation {
    @Override
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }

        switch (operation) {
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "%":
                return operand1 % operand2;
            case "abs":
                return Math.abs(operand1);
            case "sqrt":
                return Math.sqrt(operand1);
            case "exp":
                return Math.exp(operand1);
            case "**":
                return Math.pow(operand1, operand2);
            default:
                throw new RuntimeException("Unknown Operation");
        }
    }
}
