package com.lunchplace.service;
import com.lunchplace.dto.RestaurantTo;
import com.lunchplace.model.Restaurant;
import com.lunchplace.repository.RestaurantRepository;
import com.lunchplace.util.ValidationUtil;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;

import static com.lunchplace.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant get(int id) {

        return ValidationUtil.checkNotFoundWithId(restaurantRepository.getById(id), id);
    }

    @CacheEvict(value = "restaurantsCache", allEntries = true)
    public void delete(int id) {
        ValidationUtil.checkNotFoundWithId(restaurantRepository.findById(id), id);
    }

    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @CacheEvict(value = "restaurantsCache", allEntries = true)
    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        ValidationUtil.checkNotFoundWithId(restaurantRepository.save(restaurant), restaurant.getId());
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return restaurantRepository.save(restaurant);
    }


    public int getVoteCounter(int id) {
        return checkNotFoundWithId(restaurantRepository.getVoteCounter(id), id);
    }

    public void resetAllVoteCounter() {
        restaurantRepository.resetVoteCounter();
    }

    public List<RestaurantTo> getAllWithCount() {
        return restaurantRepository.getAllWithCount();
    }
}

