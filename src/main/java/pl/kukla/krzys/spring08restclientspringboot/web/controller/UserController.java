package pl.kukla.krzys.spring08restclientspringboot.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerWebExchange;
import pl.kukla.krzys.spring08restclientspringboot.service.UserService;
import reactor.core.publisher.Mono;

/**
 * @author Krzysztof Kukla
 */
@Controller
@RequestMapping("/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String getUsers() {
        return "index";
    }

    //in Reactive WebFlux, Thymeleaf will trigger below code to execute
    //    ServerWebExchange - reactive way to get params from uri
    @PostMapping
    public String formPost(Model model, ServerWebExchange serverWebExchange) {

//        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();
//
//        Integer limit = new Integer(map.get("limit").get(0));
//
//        log.debug("Received Limit value: " + limit);
//        //default if null or zero
//        if (limit == null || limit == 0) {
//            log.debug("Setting limit to default of 10");
//            limit = 10;
//        }
//
//        model.addAttribute("users", userService.findAll(limit));

        model.addAttribute("users", createUsers(serverWebExchange));

        return "userlist";
    }

    private Mono<Integer> createUsers(ServerWebExchange serverWebExchange) {
        return serverWebExchange.getFormData()
            .map(data -> Integer.valueOf(data.getFirst("limit")));
    }

}
