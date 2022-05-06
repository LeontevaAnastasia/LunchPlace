package com.lunchplace;

import com.lanchplace.model.Menu;

import java.time.LocalDate;

public class MenuTestData {
    public static final int NOT_FOUND = 10;
    public static final int MENU_FISH_HOUSE_ID = 100008;

    public static final Menu menu_shabby = new Menu(100007, LocalDate.now(), DishTestData.dishes_shabby, RestaurantTestData.shabby);
    public static final Menu menu_tokyo = new Menu(10009, LocalDate.now(), DishTestData.dishes_tokyo, RestaurantTestData.tokyo);
    public static final Menu menu_killFish = new Menu(10008, LocalDate.now(), DishTestData.dishes_killFish, RestaurantTestData.killFish);

    public static Menu getNew() {
        return new Menu(null, LocalDate.now(), null, RestaurantTestData.shabby);
    }

    public static Menu getDuplicate() {
        return new Menu(null, LocalDate.now(), null, RestaurantTestData.shabby);
    }
}
