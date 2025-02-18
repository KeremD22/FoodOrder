package com.example.foodorder1.controller;

import com.example.foodorder1.model.Dish;
import com.example.foodorder1.model.Order;
import com.example.foodorder1.repository.DishRepository;
import com.example.foodorder1.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/food_order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private DishRepository dishRepository;

    // Sipariş oluşturma
    @PostMapping
    public Order createOrder(@RequestBody @Valid Order order) {
        // Gelen order objesinde dish.id kontrol ediliyor
        if (order.getDish() == null || order.getDish().getId() == null) {
            throw new RuntimeException("Dish ID must be provided");
        }

        // Dish kontrolü
        Dish dish = dishRepository.findById(order.getDish().getId())
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        // Siparişe yemek fiyatını ekle
        order.setDish(dish);
        order.setPrice(dish.getPrice());

        return orderRepository.save(order);
    }

    // Müşteriye ait siparişleri listeleme
    @GetMapping("/customer/{customerName}")
    public List<Order> getOrderByCustomer(@PathVariable String customerName) {
        return orderRepository.findByCustomerName(customerName);  // orderRepository kullanmalısınız
    }

    // Tüm siparişleri listeleme
    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
