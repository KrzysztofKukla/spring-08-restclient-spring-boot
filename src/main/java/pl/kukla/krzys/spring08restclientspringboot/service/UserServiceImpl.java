package pl.kukla.krzys.spring08restclientspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import pl.kukla.krzys.spring08restclientspringboot.domain.User;
import pl.kukla.krzys.spring08restclientspringboot.domain.UserData;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    private final WebClient webClient;

    @Value("${api.url}")
    private String apiUrl;

    @Override
    public List<User> findAll(Integer limit) {
        String uri = createUri(limit);

        UserData userData = restTemplate.getForObject(uri, UserData.class);
        return userData.getData();
    }

    @Override
    public Flux<User> getUsers(Mono<Integer> limit) {
        String uri = createUri(limit.block());
        return webClient.get().uri(uri)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .flatMap(resp -> resp.bodyToMono(UserData.class))
            .flatMapIterable(users -> users.getData());
    }

    private String createUri(Integer limit) {
        return UriComponentsBuilder.fromUriString(apiUrl)
            .queryParam("limit", limit)
            .build()
            .toUriString();
    }

}
