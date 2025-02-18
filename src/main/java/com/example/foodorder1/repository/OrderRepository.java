package com.example.foodorder1.repository;

import com.example.foodorder1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Müşteriye ait siparişleri bulmak için metot
    List<Order> findByCustomerName(String customerName);  // Bu metodu eklediğinizden emin olun
}
