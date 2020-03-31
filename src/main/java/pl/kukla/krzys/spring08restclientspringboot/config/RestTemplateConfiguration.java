package pl.kukla.krzys.spring08restclientspringboot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Krzysztof Kukla
 */
@Configuration
public class RestTemplateConfiguration {

    //RestTemplateBuilder is autoconfigured for us
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

}
