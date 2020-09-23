package com.example.order1demo.domain.repository;

import com.example.order1demo.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
