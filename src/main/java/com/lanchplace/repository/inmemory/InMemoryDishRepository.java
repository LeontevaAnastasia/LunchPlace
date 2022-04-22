package com.lanchplace.repository.inmemory;

import com.lanchplace.model.Dish;
import com.lanchplace.repository.DishRepository;
import com.lanchplace.util.DishUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryDishRepository implements DishRepository {

    private final Map<Integer, Dish> repositoryDish = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        DishUtil.dishes.forEach(this::save);
    }

    @Override
    public Dish save(Dish dish) {
        if (dish.isNew()) {
            dish.setId(counter.incrementAndGet());
            repositoryDish.put(dish.getId(), dish);
            return dish;
        }
        // handle case: update, but not present in storage
        return repositoryDish.computeIfPresent(dish.getId(), (id, oldDish) -> dish);
        }

    @Override
    public boolean delete(int id) {
        return repositoryDish.remove(id) != null;
    }

    @Override
    public Dish get(int id) {
        return repositoryDish.get(id);
    }

    @Override
    public Collection<Dish> getAllDishes() {
        return repositoryDish.values();
    }
}
