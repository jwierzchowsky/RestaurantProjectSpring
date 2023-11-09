package com.example.RestaurantProject.service;

import com.example.RestaurantProject.domain.OrderEntity;

import java.util.List;

public interface OrderService {
    public List<OrderEntity> getAllOrders();

    public OrderEntity getOrderById(Long id);

    public OrderEntity getOrderByName(String name);

    public boolean exists(String name);

    public OrderEntity save(OrderEntity order);
    public void deleteOrderById(Long id);
}
