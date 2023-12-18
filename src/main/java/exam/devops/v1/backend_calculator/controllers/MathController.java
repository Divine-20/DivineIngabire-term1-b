package exam.devops.v1.backend_calculator.controllers;

import exam.devops.v1.backend_calculator.dtos.DoMathRequestDto;
import exam.devops.v1.backend_calculator.exceptions.InvalidOperationException;
import exam.devops.v1.backend_calculator.payload.ApiResponse;
import exam.devops.v1.backend_calculator.serviceImp.MathOperationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/doMath_calculations")
public class MathController {
    private final MathOperationImpl mathOperationImpl;
    public MathController(MathOperationImpl mathOperationImpl) {
        this.mathOperationImpl = mathOperationImpl;
    }
    @PostMapping
    public ResponseEntity<ApiResponse> create(@RequestBody DoMathRequestDto dto) throws InvalidOperationException {
        return ResponseEntity.ok(ApiResponse.success(mathOperationImpl.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation())));
    }
}
