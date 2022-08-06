package com.sakhmina.user_repository;

import com.sakhmina.authorities.Authorities;
import com.sakhmina.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private ConcurrentHashMap<User, List<Authorities>> userRepo = new ConcurrentHashMap<>();

    public UserRepository() {
        addUserAuthorities("Ivan", "password", Arrays.asList(Authorities.READ, Authorities.WRITE));
        addUserAuthorities("Alex", "password2", Arrays.asList(Authorities.READ, Authorities.WRITE));

    }

    public List<Authorities> getUserAuthorities(User user) {
        return userRepo.get(user);
    }

    public void addUserAuthorities(String user, String password, List<Authorities> listAuthorities) {
        userRepo.put(new User(user, password), listAuthorities);
    }

}
