package com.lanchplace.service;

import com.lanchplace.model.User;
import com.lanchplace.repository.UserRepository;
import com.lanchplace.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.lanchplace.util.ValidationUtil.checkNotFound;
import static com.lanchplace.util.ValidationUtil.checkNotFoundWithId;

@RequiredArgsConstructor
@Service("userService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {

    private final UserRepository userRepository;

    @CacheEvict(value = "usersCache", allEntries = true)
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return userRepository.save(user);
    }

    @CacheEvict(value = "usersCache", allEntries = true)
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(userRepository.save(user), user.id());
    }
    public void delete(int id) {
        checkNotFoundWithId(userRepository.delete(id), id);
    }

    public User get(int id) {
        return ValidationUtil.checkNotFoundWithId(userRepository.getById(id), id);
    }

    public User getByEmail(String email) {
        return checkNotFound(userRepository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }


}