package com.lunchplace.web;

import com.lanchplace.model.User;
import com.lanchplace.util.exception.NotFoundException;
import com.lanchplace.web.user.AdminRestController;
import com.lunchplace.UserTestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.lunchplace.UserTestData.*;
import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@Sql(scripts = "classpath:db/initDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class AdminRestControllerTest {

    @Autowired
    private AdminRestController controller;

    @Test
    public void create() {
        User created = controller.create(getNew());
        Integer newId = created.getId();
        User newUser = getNew();
        newUser.setId(newId);
        assertMatch(created, newUser);
        assertMatch(controller.get(newId), newUser);
    }

    @Test
    public void update() {
        User updated = getUpdated();
        controller.update(updated, updated.getId());
        assertMatch(controller.get(USER_ID), getUpdated());
    }

    @Test
    public void delete() {
        controller.delete(USER_ID);
        assertThrows(NotFoundException.class, () -> controller.get(USER_ID));
    }

    @Test
    public void get() {
        User user = controller.get(USER_ID);
        assertMatch(user, UserTestData.user);
    }

    @Test
    public void getByEmail() {
        User user = controller.getByMail("admin@mail.com");
        assertMatch(user, admin);
    }

    @Test
    public void getAll() {
        List<User> all = controller.getAll();
        assertMatch(all, admin, user, user2);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> controller.get(NOT_FOUND));
    }

    @Test
    public void deletedNotFound() {
        assertThrows(NotFoundException.class, () -> controller.delete(NOT_FOUND));
    }
}
