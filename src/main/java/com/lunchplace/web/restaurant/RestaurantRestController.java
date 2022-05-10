package com.lunchplace.web.restaurant;

import com.lunchplace.model.Restaurant;
import com.lunchplace.service.RestaurantService;
import com.lunchplace.util.DishUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;

import static com.lunchplace.util.ValidationUtil.assureIdConsistent;
import static com.lunchplace.util.ValidationUtil.checkNew;

@Controller
public class RestaurantRestController extends AbstractRestaurantController{
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

    public List<Restaurant> getAll() {
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
