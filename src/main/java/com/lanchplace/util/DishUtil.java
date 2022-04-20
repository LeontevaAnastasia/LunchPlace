package com.lanchplace.util;

import com.lanchplace.model.Dish;
import com.lanchplace.model.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DishUtil {
  // для тестирования добавили блюд, нужно их отсортировать по ресторанам и присвоить ресторану лист с его блюдом
    public static final List<Dish> dishes = Arrays.asList(
            new Dish(new Restaurant("Shabby"),"Сырный суп", 299.00, LocalDate.of(2022,Month.APRIL,20)),
            new Dish(new Restaurant("Shabby"),"Жаркое по домашнему", 350.50, LocalDate.of(2022,Month.APRIL,19)),
            new Dish(new Restaurant("Seafood"),"Салат с креветками", 420.00, LocalDate.of(2022,Month.APRIL,20)),
            new Dish(new Restaurant("Seafood"),"Том ям", 390.90, LocalDate.of(2022,Month.APRIL,18)),
            new Dish(new Restaurant("Tokyo"),"Курица в кисло-сладком соусе", 490.00, LocalDate.of(2022,Month.APRIL,18))
            );
    public static final List<Restaurant> restaurant = Arrays.asList(
            new Restaurant("Shabby"),
            new Restaurant("Seafood")
    );

    public static String getRestaurant(){
        return restaurant.toString();
    }



    List<Dish> todayDishes = new ArrayList<>();

    public static List<Dish> todayMenu(List<Dish> dishes){
        LocalDate now = LocalDate.now();
    return    dishes.stream()
                .filter(dish ->dish.getDate().compareTo(now)==0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(getDishes());
    }

    public static String getDishes(){
        return todayMenu(dishes).toString();
    }
        }

