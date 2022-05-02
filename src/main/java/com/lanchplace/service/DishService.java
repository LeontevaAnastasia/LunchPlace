package com.lanchplace.service;

import com.lanchplace.model.Dish;
import com.lanchplace.repository.DishRepository;
import com.lanchplace.repository.MenuRepository;
import com.lanchplace.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collection;

import static com.lanchplace.util.ValidationUtil.checkNotFoundWithId;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final MenuRepository menuRepository;

    public Dish get(int id, int menuId) {
        return checkNotFoundWithId(dishRepository.findById(id,menuId), id);
    }

    public void delete(int id, int menuId) {
        checkNotFoundWithId(dishRepository.delete(id, menuId), id);
    }


    public Collection<Dish> getAll(int menuId) {

        ValidationUtil.checkNotFoundWithId(menuRepository.getById(menuId), menuId);
        return dishRepository.getAll(menuId);
    }

    public void update(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(dishRepository.save(dish), dish.id());
    }

    public Dish create(Dish dish) {
        Assert.notNull(dish, "dish must not be null");
        return dishRepository.save(dish);
    }
}

