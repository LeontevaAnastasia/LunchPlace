package com.lanchplace.model;

import java.util.List;

public class Restaurant extends AbstractBaseEntity {

    private Integer id;
    private String name;
    private List <Vote> votes;
    private List<Dish> dishes;


    //public Restaurant(String name) {
     //   this.name = name;
   // }

    public Restaurant(Integer id, String name, List<Dish> dishes, List<Vote> votes) {
      super(id);
      this.name = name;
      this.dishes = dishes;
      this.votes = votes;
    }

    public Restaurant(String name, List<Dish> dishes, List <Vote> votes) {
        this(null, name,dishes,votes);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                '}';
    }

}
