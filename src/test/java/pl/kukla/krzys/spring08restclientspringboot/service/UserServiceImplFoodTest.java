package pl.kukla.krzys.spring08restclientspringboot.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

/**
 * @author Krzysztof Kukla
 */
class UserServiceImplFoodTest {

    private static final String API_ROOT = "https://api.predic8.de/shop";

    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    void fruitsTest() throws Exception {

        JsonNode jsonNode = restTemplate.getForObject(API_ROOT + "/categories", JsonNode.class);
        System.out.println(jsonNode);
    }

}