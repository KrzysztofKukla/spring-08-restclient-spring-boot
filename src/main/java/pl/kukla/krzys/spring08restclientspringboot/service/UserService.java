package pl.kukla.krzys.spring08restclientspringboot.service;

import org.springframework.http.ResponseEntity;
import pl.kukla.krzys.spring08restclientspringboot.domain.UserData;

/**
 * @author Krzysztof Kukla
 */
public interface UserService {

    ResponseEntity<UserData> findAll(Integer limit);

}
