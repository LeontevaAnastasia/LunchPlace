package com.lunchplace.web.dish;

import com.lunchplace.model.Dish;
import com.lunchplace.service.DishService;
import com.lunchplace.util.DishUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import java.util.Collection;

@Controller
public class DishRestController {

    private static final Logger log = LoggerFactory.getLogger(DishRestController.class);

    private final DishService dishService;

    public DishRestController(DishService dishService) {
        this.dishService = dishService;
    }

    public Dish get(int id, int menuId) {
        return dishService.get(id,menuId);
    }

    public void delete(int id, int menuId) {
        dishService.delete(id, menuId);
    }

    public Collection<Dish> getAll(int menuId) {
        return DishUtil.todayMenu(dishService.getAll(menuId));
    }



}

