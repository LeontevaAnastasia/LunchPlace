package com.lunchplace.web.menu;

import com.lunchplace.model.Menu;
import com.lunchplace.service.MenuService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rest/restaurants/menu")
public class MenuRestController {

    private final MenuService menuService;

    public MenuRestController(MenuService menuService) {
        this.menuService = menuService;
    }

    //Get Menu with Restaurant and Dishes for today
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Menu> getAllWithRestaurants() {
        return menuService.getAllWithRestaurants(LocalDate.now());
    }
}
