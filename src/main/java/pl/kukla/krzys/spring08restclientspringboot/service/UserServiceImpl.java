package pl.kukla.krzys.spring08restclientspringboot.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kukla.krzys.spring08restclientspringboot.domain.UserData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Krzysztof Kukla
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    @Override
    public List<UserData> findAll(Integer limit) {
        Map<String, Object> params = new HashMap<>();
        params.put("limit", limit);
        UserData userData = restTemplate.getForObject("http://apifaketory.com/api/user?limit=" + limit, UserData.class);
        return userData.getData();
    }

}
