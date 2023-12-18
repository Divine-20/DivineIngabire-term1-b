package exam.devops.v1.backend_calculator.service;

import exam.devops.v1.backend_calculator.exceptions.InvalidOperationException;
import exam.devops.v1.backend_calculator.serviceImp.MathOperationImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class MathOperationServiceUnitTest {
    @Mock
    private MathOperationImpl mathOperationService;
    @Test
    public void create_math_operation_success() throws InvalidOperationException {

        double operand1 = 10;
        double operand2 = 14;
        String operation = "+";
        double expectedResult = 24.0;

        when(mathOperationService.doMath(operand1, operand2, operation)).thenReturn(expectedResult);

        double actualMathOperator = mathOperationService.doMath(operand1, operand2, operation);

        assertThat(actualMathOperator).isEqualTo(expectedResult);
        verify(mathOperationService).doMath(operand1, operand2, operation);
    }
}
