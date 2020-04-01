package pl.kukla.krzys.spring08restclientspringboot.service;

import pl.kukla.krzys.spring08restclientspringboot.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
public interface UserService {

    List<User> findAll(Integer limit);

    Flux<User> getUsers(Mono<Integer> limit);

}
