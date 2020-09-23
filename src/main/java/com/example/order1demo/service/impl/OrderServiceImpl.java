package com.example.order1demo.service.impl;


import com.example.order1demo.domain.model.Order;
import com.example.order1demo.domain.repository.OrderRepository;
import com.example.order1demo.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrderById(Long id) throws Exception {
        Optional<Order> optOrder = this.orderRepository.findById(id);
        if (!optOrder.isPresent()) {
            throw new Exception("Order not found");
        }
        return optOrder.get();
    }

    @Override
    public Order createOrder(Order orderDTO) {
        Order order = this.orderRepository.save(Order.packingNewOrder(orderDTO));
        return order;
    }
}
