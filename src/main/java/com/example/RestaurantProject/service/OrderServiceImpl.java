package com.example.RestaurantProject.service;

import com.example.RestaurantProject.domain.OrderEntity;
import com.example.RestaurantProject.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAllOrders(){
        return orderRepository.findAll();
    }
    @Override
    public OrderEntity getOrderById(Long id){
        return orderRepository.findById(id).orElse(null);
    }
    @Override
    public OrderEntity getOrderByName(String name){
        return orderRepository.findByName(name);
    }
    @Override
    public boolean exists(String name){
        if(orderRepository.findByName(name)!=null){
            return true;
        }
        return false;
    }
    @Override
    public OrderEntity save(OrderEntity order){
        return orderRepository.save(order);
    }
    @Override
    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }
}
