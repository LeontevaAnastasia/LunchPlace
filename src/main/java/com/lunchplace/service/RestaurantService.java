package com.lunchplace.service;
import com.lunchplace.model.Restaurant;
import com.lunchplace.repository.RestaurantRepository;
import com.lunchplace.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;

import static com.lunchplace.util.ValidationUtil.checkNotFoundWithId;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant get(int id) {

        return ValidationUtil.checkNotFoundWithId(restaurantRepository.getById(id), id);
    }

    @CacheEvict(value = "restaurantsCache", allEntries = true)
    public void delete(int id) {
        ValidationUtil.checkNotFoundWithId(restaurantRepository.findById(id), id);
    }

    public Collection<Restaurant> getAll() {
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

    @CacheEvict(value = "restaurantsCache", allEntries = true)
    public void incrementVoteCounter(int id) {
        int counter = getVoteCounter(id);
        counter++;
        checkNotFoundWithId(restaurantRepository.incrementVoteCounter(id), id);
    }

    public int getVoteCounter(int id) {
        return checkNotFoundWithId(restaurantRepository.getVoteCounter(id), id);
    }

    public void resetAllVoteCounter() {
        restaurantRepository.resetVoteCounter();
    }
}

