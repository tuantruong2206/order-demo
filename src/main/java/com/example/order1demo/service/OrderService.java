package com.example.order1demo.service;


import com.example.order1demo.domain.model.Order;

public interface OrderService {

    public Order getOrderById(Long id) throws Exception;
    public Order createOrder(Order orderDTO);

}
