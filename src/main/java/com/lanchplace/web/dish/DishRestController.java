package com.lanchplace.web.dish;

import com.lanchplace.model.Dish;
import com.lanchplace.service.DishService;
import com.lanchplace.util.DishUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import static com.lanchplace.util.ValidationUtil.assureIdConsistent;
import static com.lanchplace.util.ValidationUtil.checkNew;

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

