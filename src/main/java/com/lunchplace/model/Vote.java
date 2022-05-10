package com.lunchplace.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "vote", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "created"}, name = "vote_unique_user_created_idx")})
public class Vote extends AbstractBaseEntity {

    @Column(name = "user_id", nullable = false)
    @NotNull
    private int userId;

    @Column(name = "rest_id", nullable = false)
    @NotNull
    private int restaurantId;

    @Column(name = "created", nullable = false)
    @NotNull
    private LocalDate date;

    public Vote(){

    }
    public Vote(Integer userId, Integer restaurantId) {
        this(null, LocalDate.now(), userId, restaurantId);
    }

    public Vote(Integer id, LocalDate date, Integer userId, Integer restaurantId) {
        super(id);
        this.date = date;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", date=" + date +
                ", userId=" + userId +
                ", restaurantId=" + restaurantId +
                '}';
    }
}
