package com.lunchplace.repository;

import com.lunchplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("delete from User u where u.id=:id")
    int delete(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.restaurantId=:restaurantId WHERE u.id=:userId")
    int setRestaurantId(@Param("userId") int userId, @Param("restaurantId") int restaurantId);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.restaurantId=0")
    void resetAllRestaurantId();

    Optional<User> getById(int id);

    @Query("select u from User u where u.email=:email")
    User getByEmail(@Param("email") String email);

}