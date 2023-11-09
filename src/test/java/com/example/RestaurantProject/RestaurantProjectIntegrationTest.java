package com.example.RestaurantProject;

import com.example.RestaurantProject.domain.OrderEntity;
import com.example.RestaurantProject.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.http.MediaType;

@AutoConfigureTestDatabase
public class RestaurantProjectIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrderRepository repository;

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    @Test
    public void whenValidInput_thenCreateStudent() throws IOException, Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        OrderEntity firstOrder = new OrderEntity("Schabowy", 1, formatter.parse("2023-11-09"));

        mvc.perform(post("/api/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(firstOrder)));

        List<OrderEntity> found = repository.findAll();
        assertThat(found).extracting(OrderEntity::getName).containsOnly("Schabowy");

    }
}