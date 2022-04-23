package com.lanchplace.repository;

import com.lanchplace.model.Dish;
import com.lanchplace.model.Restaurant;

import java.util.Collection;
import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);

    // false if not found
    boolean delete(int id);

    // null if not found
    Restaurant get(int id);

    Collection<Restaurant> getAllRestaurant();
}
