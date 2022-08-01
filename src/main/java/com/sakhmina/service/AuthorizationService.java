package com.sakhmina.service;

import com.sakhmina.exceptions.InvalidCredentials;
import com.sakhmina.exceptions.UnauthorizedUser;
import com.sakhmina.authorities.Authorities;
import com.sakhmina.user_repository.UserRepository;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class AuthorizationService {
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) throws InvalidCredentials, UnauthorizedUser {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
