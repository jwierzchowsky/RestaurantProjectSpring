package com.example.RestaurantProject.controller;
import com.example.RestaurantProject.domain.OrderEntity;
import com.example.RestaurantProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public OrderEntity getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public ResponseEntity<OrderEntity> addOrder(@RequestBody OrderEntity order) {
        HttpStatus status = HttpStatus.CREATED;
        OrderEntity saved = orderService.save(order);
        return new ResponseEntity<>(saved,status);
    }

    @PutMapping("/orders/{id}")
    public OrderEntity updateOrder(@PathVariable Long id, @RequestBody OrderEntity updatedOrderEntity) {
        OrderEntity existingOrderEntity = orderService.getOrderById(id);

        if (existingOrderEntity != null) {
            existingOrderEntity.setName(updatedOrderEntity.getName());
            existingOrderEntity.setQuantity(updatedOrderEntity.getQuantity());
            return orderService.save(existingOrderEntity);
        } else {
            return null;
        }
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
}