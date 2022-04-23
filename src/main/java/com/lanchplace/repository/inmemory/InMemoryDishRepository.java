package com.lanchplace.repository.inmemory;

import com.lanchplace.model.Dish;
import com.lanchplace.repository.DishRepository;
import com.lanchplace.util.DishUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class InMemoryDishRepository implements DishRepository {

    private final Map<Integer, Dish> dishMap = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);
    {
        DishUtil.dishes.forEach(this::save);
    }

    @Override
    public Dish save(Dish dish) {
        // We cannot use method reference "ConcurrentHashMap::new" here. It will be equivalent wrong "new ConcurrentHashMap<>(userId)"

        if (dish.isNew()) {
            dish.setId(counter.incrementAndGet());
            dishMap.put(dish.getId(), dish);
            return dish;
        }
        return dishMap.computeIfPresent(dish.getId(), (id, oldMeal) -> dish);
    }

    public boolean delete(int id) {
        return dishMap != null && dishMap.remove(id) != null;
    }

    @Override
    public Dish get(int id) {
        return dishMap == null ? null : dishMap.get(id);
    }

    @Override
    public Collection<Dish> getAllDishes() {
        return todayMenu(dishMap.values()) ;
    }


    public  List<Dish> todayMenu(Collection<Dish> dishes){
        LocalDate now = LocalDate.now();
        return    dishes.stream()
                .filter(dish ->dish.getDate().compareTo(now)==0)
                .collect(Collectors.toList());
    }
}
