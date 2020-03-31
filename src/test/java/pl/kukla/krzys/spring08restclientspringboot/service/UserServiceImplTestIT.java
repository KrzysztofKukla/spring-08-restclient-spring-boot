package pl.kukla.krzys.spring08restclientspringboot.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @author Krzysztof Kukla
 */
@SpringBootTest
    // contains @ExtendWith(SpringExtension.class)
class UserServiceImplTestIT {

    @MockBean
    private RestClientTest restClientTest;

    @Autowired
    private UserService userService;

    @Test
    void findAll() {
        userService.findAll(3);
    }

}