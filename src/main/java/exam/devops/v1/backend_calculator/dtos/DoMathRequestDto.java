package exam.devops.v1.backend_calculator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class DoMathRequestDto {
    private double operand1;
    private double operand2;
    private String operation;
}