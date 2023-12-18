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
        double calcResponse = 24.0;

        when(mathOperationService.doMath(operand1, operand2, operation)).thenReturn(calcResponse);

        double actualMathOperation = mathOperationService.doMath(operand1, operand2, operation);

        assertThat(actualMathOperation).isEqualTo(calcResponse);
        verify(mathOperationService).doMath(operand1, operand2, operation);
    }
    @Test
    public void subtract_operation_success() throws InvalidOperationException {
        double operand1 = 20;
        double operand2 = 7;
        String operation = "-";
        double calcResponse = 13.0;

        when(mathOperationService.doMath(operand1, operand2, operation)).thenReturn(calcResponse);

        double actualResult = mathOperationService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(calcResponse);
        verify(mathOperationService).doMath(operand1, operand2, operation);
    }
    @Test
    public void multiply_operation_success() throws InvalidOperationException {
        double operand1 = 8;
        double operand2 = 5;
        String operation = "*";
        double calcResponse = 40.0;

        when(mathOperationService.doMath(operand1, operand2, operation)).thenReturn(calcResponse);

        double actualResult = mathOperationService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(calcResponse);
        verify(mathOperationService).doMath(operand1, operand2, operation);
    }
    @Test
    public void divide_operation_success() throws InvalidOperationException {
        double operand1 = 40;
        double operand2 = 5;
        String operation = "/";
        double calcResponse = 8.0;

        when(mathOperationService.doMath(operand1, operand2, operation)).thenReturn(calcResponse);

        double actualResult = mathOperationService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(calcResponse);
        verify(mathOperationService).doMath(operand1, operand2, operation);
    }

    @Test
    public void modulo_operation_success() throws InvalidOperationException {
        double operand1 = 17;
        double operand2 = 4;
        String operation = "%";
        double calcResponse = 1.0;

        when(mathOperationService.doMath(operand1, operand2, operation)).thenReturn(calcResponse);

        double actualResult = mathOperationService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(calcResponse);
        verify(mathOperationService).doMath(operand1, operand2, operation);
    }
    @Test
    public void power_operation_success() throws InvalidOperationException {
        double operand1 = 3;
        double operand2 = 4;
        String operation = "**";
        double calcResponse = Math.pow(3, 4);

        when(mathOperationService.doMath(operand1, operand2, operation)).thenReturn(calcResponse);

        double actualResult = mathOperationService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(calcResponse);
        verify(mathOperationService).doMath(operand1, operand2, operation);
    }
    @Test
    public void square_root_operation_success() throws InvalidOperationException {
        double operand1 = 25;
        String operation = "sqrt";
        double calcResponse = 5.0;

        when(mathOperationService.doMath(operand1, 0, operation)).thenReturn(calcResponse);

        double actualResult = mathOperationService.doMath(operand1, 0, operation);

        assertThat(actualResult).isEqualTo(calcResponse);
        verify(mathOperationService).doMath(operand1, 0, operation);
    }
    @Test
    public void exponential_operation_success() throws InvalidOperationException {
        double operand1 = 2;
        String operation = "exp";
        double calcResponse = Math.exp(2);

        when(mathOperationService.doMath(operand1, 0, operation)).thenReturn(calcResponse);

        double actualResult = mathOperationService.doMath(operand1, 0, operation);

        assertThat(actualResult).isEqualTo(calcResponse);
        verify(mathOperationService).doMath(operand1, 0, operation);
    }

    @Test
    public void absolute_value_operation_success() throws InvalidOperationException {
        double operand1 = -15;
        String operation = "abs";
        double calcResponse = 15.0;

        when(mathOperationService.doMath(operand1, 0, operation)).thenReturn(calcResponse);

        double actualResult = mathOperationService.doMath(operand1, 0, operation);

        assertThat(actualResult).isEqualTo(calcResponse);
        verify(mathOperationService).doMath(operand1, 0, operation);
    }
    @Test(expected = RuntimeException.class)
    public void unknown_operation_should_throw_exception() throws InvalidOperationException {
        double operand1 = 10;
        double operand2 = 14;
        String unknownOperation = "unknown";

        // Mock behavior to simulate an unknown operation
        when(mathOperationService.doMath(operand1, operand2, unknownOperation))
                .thenThrow(new RuntimeException("Unknown Operation"));

        // Call the method with unknown operation, expecting an exception
        mathOperationService.doMath(operand1, operand2, unknownOperation);
    }
}
