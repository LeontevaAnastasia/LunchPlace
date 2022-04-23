package com.lanchplace.service;
import com.lanchplace.model.Restaurant;
import com.lanchplace.repository.DishRepository;
import com.lanchplace.repository.RestaurantRepository;

import java.util.Collection;
import java.util.List;

import static com.lanchplace.util.ValidationUtil.checkNotFoundWithId;

public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(restaurantRepository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(restaurantRepository.delete(id), id);
    }


    public Collection<Restaurant> getAll() {
        return restaurantRepository.getAllRestaurant();
    }

    public void update(Restaurant restaurant) {
        checkNotFoundWithId(restaurantRepository.save(restaurant), restaurant.getId());
    }

    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}

