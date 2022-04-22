package com.lanchplace.repository;

import com.lanchplace.model.Dish;

import java.util.Collection;
import java.util.List;

public interface DishRepository {

    Dish save(Dish meal);

    // false if not found
    boolean delete(int id);

    // null if not found
    Dish get(int id);

    Collection<Dish> getAllDishes();
}


