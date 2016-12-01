package io.pivotal.spring.web;

import io.pivotal.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    private UserService userService;

    public ApiController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/")
    public String index() {
        return userService.getAddress("Iron Man");
    }
}
