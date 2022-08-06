package com.sakhmina.controller;

import com.sakhmina.authorities.Authorities;
import com.sakhmina.domain.User;
import com.sakhmina.exceptions.InvalidCredentials;
import com.sakhmina.exceptions.UnauthorizedUser;
import com.sakhmina.service.AuthorizationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) throws InvalidCredentials, UnauthorizedUser {
        return service.getAuthorities(user);
    }

}
