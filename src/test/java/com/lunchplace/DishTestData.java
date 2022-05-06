package com.lunchplace;

import com.lanchplace.model.Dish;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DishTestData {

    public static final int NOT_FOUND = 10;
    public static final int DISH1_ID = 100015;

    public static final Dish dish1 = new Dish(100011, "Салат с морепродуктами", 350.00, MenuTestData.menu_shabby);
    public static final Dish dish2 = new Dish(100012, "Сырный суп", 150.00, MenuTestData.menu_shabby);
    public static final Dish dish3 = new Dish(100013, "Стейк New-York", 670.00, MenuTestData.menu_killFish);

    public static final Dish dish4 = new Dish(100014, "Чизбургер", 250.00, MenuTestData.menu_killFish);
    public static final Dish dish5 = new Dish(100015, "Матча-Латте", 240.00, MenuTestData.menu_killFish);
    public static final Dish dish6 = new Dish(100016, "Боул с угрем", 400.00, MenuTestData.menu_tokyo);

    public static final List<Dish> dishes_shabby = List.of(dish1, dish2).stream()
            .sorted(Comparator.comparing(Dish::getDescription))
            .collect(Collectors.toList());

    public static final List<Dish> dishes_killFish = List.of(dish3,dish4,dish5);
    public static final List<Dish> dishes_tokyo = List.of(dish6);

    public static Dish getNew() {
        return new Dish(null, "New dish", 100.00, null);
    }

    public static Dish getNewDuplicated() {
        return new Dish(null, dish1.getDescription(), 350.00, MenuTestData.menu_shabby);
    }

    public static Dish getUpdated() {
        return new Dish(DISH1_ID, "Updated salad", 100.00, MenuTestData.menu_shabby);
    }
}
