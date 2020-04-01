package pl.kukla.krzys.spring08restclientspringboot.service;

import pl.kukla.krzys.spring08restclientspringboot.domain.User;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
public interface UserService {

    List<User> findAll(Integer limit);

}
