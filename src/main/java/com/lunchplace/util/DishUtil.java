package com.lunchplace.util;

import com.lunchplace.model.Dish;
import com.lunchplace.model.Restaurant;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DishUtil {
  // для тестирования добавили блюд, нужно их отсортировать по ресторанам и присвоить ресторану лист с его блюдом
    public static final List<Dish> dishes = Arrays.asList(
            new Dish("Сырный суп", 299.00),
            new Dish("Жаркое по домашнему", 350.50),
            new Dish("Салат с креветками", 420.00),
            new Dish("Том ям", 390.70),
            new Dish("Курица в кисло-сладком соусе", 490.00)
            );

    public static final Collection<Restaurant> restaurant = Arrays.asList(
            new Restaurant("Shabby"),
            new Restaurant("Seafood"),
            new Restaurant("Tokyo")
    );

    public static List<Restaurant> getRestaurant(List<Restaurant> restaurant){
        return restaurant;
    }


    public static List<Dish> todayMenu(Collection<Dish> dishes){
        LocalDate now = LocalDate.now();
    return    dishes.stream()
               // .filter(dish ->dish.getDate().compareTo(now)==0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(getDishes());
    }

    public static String getDishes(){
        return todayMenu( dishes).toString();
    }
        }

