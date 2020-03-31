package pl.kukla.krzys.spring08restclientspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.kukla.krzys.spring08restclientspringboot.domain.UserData;

import java.util.List;

/**
 * @author Krzysztof Kukla
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    @Value("${api.url}")
    private final String apiUrl;

    @Override
    public List<UserData> findAll(Integer limit) {
        UriComponents uriComponent = UriComponentsBuilder.fromUriString(apiUrl)
            .queryParam("limit", limit)
            .build();

        UserData userData = restTemplate.getForObject(uriComponent.toUriString(), UserData.class);
        return userData.getData();
    }

}
