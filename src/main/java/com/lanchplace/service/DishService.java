package com.lanchplace.service;

import com.lanchplace.model.Dish;
import com.lanchplace.repository.DishRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static com.lanchplace.util.ValidationUtil.checkNotFoundWithId;

@Service
public class DishService {
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish get(int id) {
        return checkNotFoundWithId(dishRepository.get(id), id);
    }

    public void delete(int id) {
        checkNotFoundWithId(dishRepository.delete(id), id);
    }


    public Collection<Dish> getAll() {
        return dishRepository.getAllDishes();
    }

    public void update(Dish dish) {
        checkNotFoundWithId(dishRepository.save(dish), dish.getId());
    }

    public Dish create(Dish dish) {
        return dishRepository.save(dish);
    }
}

