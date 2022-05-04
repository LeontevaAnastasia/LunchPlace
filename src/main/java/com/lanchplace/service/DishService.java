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

        return ValidationUtil.checkNotFoundWithId(dishRepository.findById(id, menuId), id);
    }

    public void delete(int id, int menuId) {

        checkNotFoundWithId(dishRepository.delete(id, menuId),id);

    }


    public Collection<Dish> getAll(int menuId) {

        ValidationUtil.checkNotFoundWithId(menuRepository.getById(menuId), menuId);
        return dishRepository.getAll(menuId);
    }

    public void update(Dish dish,int menuId) {
        Assert.notNull(dish, "dish must not be null");
        ValidationUtil.checkNotFoundWithId(save(dish, menuId), dish.getId());
    }

    public Dish create(Dish dish, int menuId) {
        Assert.notNull(dish, "Dish must not be null.");
        ValidationUtil.IsUniqueDishNameForMenu(dishRepository.getByName(dish.getDescription(), menuId) != null);

        return save(dish,menuId);
    }

    public Dish save(Dish dish, int menuId) {
        if (!dish.isNew() && get(dish.getId(), menuId) == null) {
            return null;
        }
        dish.setMenu(menuRepository.getOne(menuId));
        return dishRepository.save(dish);
    }
}

