package com.example.foodorder1.repository;

import com.example.foodorder1.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, Long> {
    Optional<Dish> findByName(String name);
}
