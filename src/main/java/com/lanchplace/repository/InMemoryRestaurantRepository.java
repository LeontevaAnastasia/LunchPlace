package com.lanchplace.repository;

import com.lanchplace.model.Dish;
import com.lanchplace.model.Restaurant;
import com.lanchplace.util.DishUtil;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryRestaurantRepository implements RestaurantRepository {
    private final Map<Integer, Restaurant> restaurantRepository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        DishUtil.restaurant.forEach(this::save);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        restaurant.setId(counter.incrementAndGet());
        restaurantRepository.put(restaurant.getId(), restaurant);
        return restaurant;
    }

    @Override
    public boolean delete(int id) {
        return restaurantRepository.remove(id) != null;
    }

    @Override
    public Restaurant get(int id) {
        return restaurantRepository.get(id);
    }

    @Override
    public Collection<Restaurant> getAllRestaurant() {
        return restaurantRepository.values();
    }
}


