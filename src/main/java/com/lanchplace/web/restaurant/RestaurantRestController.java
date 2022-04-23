package com.lanchplace.web.restaurant;

import com.lanchplace.model.Dish;
import com.lanchplace.model.Restaurant;
import com.lanchplace.service.DishService;
import com.lanchplace.service.RestaurantService;
import com.lanchplace.util.DishUtil;
import com.lanchplace.web.dish.DishRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;

import static com.lanchplace.util.ValidationUtil.assureIdConsistent;
import static com.lanchplace.util.ValidationUtil.checkNew;

public class RestaurantRestController {
    private final RestaurantService restaurantService;
    private static final Logger log = LoggerFactory.getLogger(RestaurantRestController.class);

    public RestaurantRestController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public Restaurant get(int id) {
        return restaurantService.get(id);
    }

    public void delete(int id) {
        restaurantService.delete(id);
    }

    public Collection<Restaurant> getAll() {
        return DishUtil.getRestaurant(restaurantService.getAll());
    }

    public Restaurant create(Restaurant restaurant) {
        checkNew(restaurant);
        log.info("create {}", restaurant);
        return restaurantService.create(restaurant);
    }

    public void update(Restaurant restaurant, int id) {
        assureIdConsistent(restaurant, id);
        log.info("update {}", restaurant);
        restaurantService.update(restaurant);
    }
}
