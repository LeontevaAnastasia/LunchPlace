package com.lanchplace.service;

import com.lanchplace.model.User;
import com.lanchplace.repository.UserRepository;
import com.lanchplace.util.UserUtil;
import com.lanchplace.util.ValidationUtil;
import com.lanchplace.util.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.lanchplace.util.ValidationUtil.checkNotFound;
import static com.lanchplace.util.ValidationUtil.checkNotFoundWithId;

@RequiredArgsConstructor
@Service("userService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @CacheEvict(value = "usersCache", allEntries = true)
    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return prepareAndSave(user);
    }

    @CacheEvict(value = "usersCache", allEntries = true)
    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        prepareAndSave(user);
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

    @Transactional
    public void resetAllRestaurantId() {
        userRepository.resetAllRestaurantId();
    }

    @Transactional
    public void enable(int id, boolean enabled) {
        User user = userRepository.getById(id).orElse(null);
        if (user == null) {
            throw new NotFoundException("User with id " + id + " doesn't exists.");
        }
        user.setEnabled(enabled);
    }



    private User prepareAndSave(User user) {

        return userRepository.save(UserUtil.prepareToSave(user, passwordEncoder));
    }

}