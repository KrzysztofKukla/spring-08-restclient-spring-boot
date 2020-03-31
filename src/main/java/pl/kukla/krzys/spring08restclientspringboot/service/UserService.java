package pl.kukla.krzys.spring08restclientspringboot.service;

import pl.kukla.krzys.spring08restclientspringboot.domain.UserData;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
public interface UserService {

    List<UserData> findAll(Integer limit);

}
