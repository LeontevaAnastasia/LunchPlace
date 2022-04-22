package com.lanchplace.service;

import com.lanchplace.model.User;
import com.lanchplace.repository.UserRepository;

import java.util.List;

import static com.lanchplace.util.ValidationUtil.checkNotFound;
import static com.lanchplace.util.ValidationUtil.checkNotFoundWithId;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(int id) {
        checkNotFoundWithId(userRepository.delete(id), id);
    }

    public User get(int id) {
        return checkNotFoundWithId(userRepository.get(id), id);
    }

    public User getByEmail(String email) {
        return checkNotFound(userRepository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public void update(User user) {
        checkNotFoundWithId(userRepository.save(user), user.getId());
    }
}