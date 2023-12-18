package exam.devops.v1.backend_calculator;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BackendCalculatorApplicationEndToEndTests {

    @LocalServerPort
    private String port = "8080";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testApiEndpoint() throws JSONException {
        // Given
        String url = "http://localhost:" + port + "/api/v1/doMath_calculations";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestBody = "{\"operand1\": 20, \"operand2\": 40, \"operation\": \"+\"}";

        // When
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        String response = restTemplate.postForObject(url, request, String.class);
        JSONTokener tokener = new JSONTokener(response);
        JSONObject jsonObject = new JSONObject(tokener);
        Double result = jsonObject.getDouble("data");
        // Then
        assertEquals(60.0, result, 0.01);
    }
}
