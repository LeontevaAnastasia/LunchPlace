package com.lanchplace.util;

import com.lanchplace.model.Dish;
import com.lanchplace.model.Restaurant;
import com.lanchplace.model.Vote;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class DishUtil {
  // для тестирования добавили блюд, нужно их отсортировать по ресторанам и присвоить ресторану лист с его блюдом
    public static final List<Dish> dishes = Arrays.asList(
            new Dish(new Restaurant("Shabby").getName(),"Сырный суп", 299.00, LocalDate.of(2022,Month.APRIL,20)),
            new Dish(new Restaurant("Shabby").getName(),"Жаркое по домашнему", 350.50, LocalDate.of(2022,Month.APRIL,19)),
            new Dish(new Restaurant("Seafood").getName(),"Салат с креветками", 420.00, LocalDate.of(2022,Month.APRIL,24)),
            new Dish(new Restaurant("Seafood").getName(),"Том ям", 390.90, LocalDate.of(2022,Month.APRIL,23)),
            new Dish(new Restaurant("Tokyo").getName(),"Курица в кисло-сладком соусе", 490.00, LocalDate.of(2022,Month.APRIL,22))
            );

    public static final List<Restaurant> restaurant = Arrays.asList(
            new Restaurant("Shabby"),
            new Restaurant("Seafood"),
            new Restaurant("Tokyo")
    );

    public static String getRestaurant(){
        return restaurant.toString();
    }



    List<Dish> todayDishes = new ArrayList<>();

    public static List<Dish> todayMenu(Collection<Dish> dishes){
        LocalDate now = LocalDate.now();
    return    dishes.stream()
                .filter(dish ->dish.getDate().compareTo(now)==0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(getDishes());
    }

    public static String getDishes(){
        return todayMenu( dishes).toString();
    }
        }

