package dio.spring_security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome(){
        return "Welcome to my Spring Boot Web API!";
    }

    @GetMapping("/users")
    //@PreAuthorize("hasAnyRole('MANAGERS', 'USERS')")
    public String users(){
        return "Authorized user";
    }

    @GetMapping("/managers")
    //@PreAuthorize("hasRole('MANAGERS')")
    public String manager(){
        return "Authorized manager";
    }
}
