package exam.devops.v1.backend_calculator.service;

import exam.devops.v1.backend_calculator.exceptions.InvalidOperationException;

public interface IMathOperation {

    double doMath(double operand1, double operand2, String operation) throws InvalidOperationException;
}
