package com.example.foodorder1.controller;

import com.example.foodorder1.model.Dish;
import com.example.foodorder1.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // List importu ekleyin

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishRepository dishRepository;

    // 1. Yemek Tanımla
    @PostMapping
    public Dish createDish(@RequestBody Dish dish) {
        return dishRepository.save(dish);
    }

    // 2. Yemekleri Listele
    @GetMapping
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }
}
