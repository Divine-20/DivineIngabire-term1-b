package exam.devops.v1.backend_calculator.controllers;

import exam.devops.v1.backend_calculator.dtos.DoMathRequestDto;
import exam.devops.v1.backend_calculator.payload.ApiResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void doMathOperation_Addition
            () {
        DoMathRequestDto dto = new DoMathRequestDto(34, 21, "+");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCode().value());
    }
    @Test
    public void doMathOperation_Subtraction() {
        DoMathRequestDto dto = new DoMathRequestDto(50, 20, "-");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCodeValue());

    }
    @Test
    public void doMathOperation_Multiplication() {
        DoMathRequestDto dto = new DoMathRequestDto(10, 5, "*");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    public void doMathOperation_Division() {
        DoMathRequestDto dto = new DoMathRequestDto(100, 20, "/");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCodeValue());

    }
    @Test
    public void doMathOperation_Modulo() {
        DoMathRequestDto dto = new DoMathRequestDto(15, 4, "%");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCodeValue());

    }
    @Test
    public void doMathOperation_Absolute() {
        DoMathRequestDto dto = new DoMathRequestDto(-10, 0, "abs");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCodeValue());

    }

    @Test
    public void doMathOperation_SquareRoot() {
        DoMathRequestDto dto = new DoMathRequestDto(25, 0, "sqrt");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCodeValue());

    }
    @Test
    public void doMathOperation_Exponential() {

        DoMathRequestDto dto = new DoMathRequestDto(2, 0, "exp");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCodeValue());

    }
    @Test
    public void doMathOperation_Power() {

        DoMathRequestDto dto = new DoMathRequestDto(3, 4, "**");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCodeValue());

    }
    @Test
    public void doMathOperation_Unknown() {
        DoMathRequestDto dto = new DoMathRequestDto(10, 5, "unknown");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(500, response.getStatusCodeValue());
    }
}
