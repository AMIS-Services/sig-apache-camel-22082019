package ${groupId}.${artifactId}Test.routes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExampleCamelRouteTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void appointmentTest() {
        // call the REST API
        ResponseEntity<String> response = restTemplate.getForEntity("/camel-api/jokes/v1/random", String.class);
        // check if Http respons status is matching
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        // check if respons body is matching
//        String responseBody = response.getBody();
//        assertThat(responseBody.equals(
//                "{\n" +
//                        "    Chuck is the best!\n" +
//                        "}\n"));
    }

}