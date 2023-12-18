package exam.devops.v1.backend_calculator;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackendCalculatorApplicationEndToEndTests {

    @LocalServerPort
    private String port = "8080";
    private final TestRestTemplate restTemplate = new TestRestTemplate();
    @Test
    public void should_return_EndpointTest_success() {
        String url = "http://localhost:" + port + "/api/v1/doMath_calculations";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
