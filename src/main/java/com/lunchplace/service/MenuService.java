package com.lunchplace.service;

import com.lunchplace.model.Menu;
import com.lunchplace.repository.MenuRepository;
import com.lunchplace.repository.RestaurantRepository;
import com.lunchplace.util.ValidationUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDate;
import java.util.List;

import static com.lunchplace.util.ValidationUtil.checkNotFoundWithId;

@Service

public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    public MenuService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Transactional
    @CacheEvict(value = "menus", allEntries = true)
    public Menu create(Menu menu, int restaurantId) {
        Assert.notNull(menu, "Menu must not be null.");
        checkNotFoundWithId(restaurantRepository.getById(restaurantId), restaurantId);

        if (!menu.isNew()) {
            return null;
        }
        menu.setRestaurant(restaurantRepository.getOne(restaurantId));
        return menuRepository.save(menu);

    }

    @CacheEvict(value = "menus", allEntries = true)
    public void delete(int id) {
        checkNotFoundWithId(menuRepository.delete(id), id);
    }

    public Menu get(int id) {
        return ValidationUtil.checkNotFoundWithId(menuRepository.findById(id), id);
    }

    public Menu getByRestaurant(int restaurantId, LocalDate date) {
        return ValidationUtil.checkNotFoundWithId(menuRepository.getByRestaurantIdAndDate(restaurantId, date), restaurantId);
    }

    @Cacheable("menus")
    public List<Menu> getAllWithRestaurants(LocalDate date) {

        return menuRepository.getAllWithRestaurant(date);
    }





}
