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
    public void doMathOperation_Success() {
        DoMathRequestDto dto = new DoMathRequestDto(34, 21, "+");
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/doMath_calculations", dto, ApiResponse.class);
        assertEquals(200, response.getStatusCode().value());
    }
}
