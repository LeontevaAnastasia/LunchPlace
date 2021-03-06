package com.lunchplace;

import com.lunchplace.model.Restaurant;

import java.util.List;

public class RestaurantTestData {
    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator(Restaurant.class);

    public static final int NOT_FOUND = 10;
    public static final int START_SEQ = 10000;
    public static final int RESTAURANT_ID = START_SEQ + 3;

    public static final Restaurant shabby = new Restaurant(100003, "Shabby");
    public static final Restaurant killFish = new Restaurant(100004, "KillFish");
    public static final Restaurant tokyo = new Restaurant(100005, "Tokyo");
    public static final Restaurant teremok = new Restaurant(100006, "Teremok");

    public static Restaurant getNew() {
        return new Restaurant(null, "New");
    }

    public static Restaurant getNewDuplicate() {
        return new Restaurant(null, "Shabby");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT_ID, "Updated");
    }

    public static List<Restaurant> getAll = List.of(shabby,killFish,tokyo,teremok);
}
