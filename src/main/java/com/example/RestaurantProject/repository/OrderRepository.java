package com.example.RestaurantProject.repository;

import com.example.RestaurantProject.domain.OrderEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    public List<OrderEntity> findAll();
    public OrderEntity findByName(String name);

}
