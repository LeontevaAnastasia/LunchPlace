package com.lunchplace;

import com.lanchplace.model.Role;
import com.lanchplace.model.User;

import java.util.Arrays;
import java.util.Collections;

import static com.lanchplace.model.AbstractBaseEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;


public class UserTestData {

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int NOT_FOUND = 10;
    public static final int WITH_REST_ID = 10003;

    public static final User user = new User(USER_ID, "BobUser", "bob@mail.com", "Password", null, Role.USER);
    public static final User user2 = new User(USER_ID, "MikeUser", "mike@mail.com", "123", null, Role.USER);
    public static final User admin = new User(ADMIN_ID, "Admin", "admin@mail.com", "Password2", null, Role.ADMIN, Role.USER);

    public static User getNew() {

        return new User(1, "NewUser", "newUser@mail.com", "123", 1003, Role.USER);
    }

    public static User getUpdated() {
        User updatedUser = new User(user);
        updatedUser.setId(USER_ID);
        updatedUser.setName("User1");
        updatedUser.setEmail("user1@mail.ru");
        updatedUser.setPassword("123");
        updatedUser.setRestaurantId(2);
        updatedUser.setRoles(Collections.singletonList(Role.ADMIN));
        return updatedUser;
    }

    public static User getWithResetRestID1() {
        User updatedUser = new User(user);
        updatedUser.setRestaurantId(0);
        return updatedUser;
    }

    public static User getWithResetRestID2() {
        User updatedUser = new User(admin);
        updatedUser.setRestaurantId(0);
        return updatedUser;
    }

    public static User getWithRestaurantId() {
        User withRestId = new User(user);
        withRestId.setRestaurantId(WITH_REST_ID);
        return withRestId;
    }

    public static void assertMatch(User actual, User expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("registered", "roles").isEqualTo(expected);
    }

    public static void assertMatch(Iterable<User> actual, User... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }
    public static void assertMatch(Iterable<User> actual, Iterable<User> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields("registered", "roles", "checkTimeVote").isEqualTo(expected);
    }


}
