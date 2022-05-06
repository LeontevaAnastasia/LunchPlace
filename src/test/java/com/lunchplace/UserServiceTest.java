package com.lunchplace;

import com.lanchplace.model.User;
import com.lanchplace.repository.UserRepository;
import com.lanchplace.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.lunchplace.UserTestData.*;
import static org.junit.Assert.assertEquals;


public class UserServiceTest {
    @Autowired
    protected UserService userService;

    @Autowired
    protected UserRepository userRepository;

    @Test
    public void delete() {
        userService.delete(USER_ID);
        Assert.assertNull(userRepository.getById(USER_ID));
    }

    @Test
    public void create() {
        User created = userService.create(getNew());
        int newId = created.id();
        User newUser = getNew();
        newUser.setId(newId);
        assertMatch(created, newUser);
        assertMatch(userService.get(newId), newUser);
    }
}
