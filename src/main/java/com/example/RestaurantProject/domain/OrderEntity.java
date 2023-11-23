package com.example.RestaurantProject.domain;

import jakarta.persistence.*;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Entity
@Table(name = "'order'")
@Data
public class OrderEntity {

    public OrderEntity(){

    }
    public OrderEntity(String name){
        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private static final String menu = "Kotlet schabowy|pierogi|Filet z Kurczaka|Frytki|Ziemniaki|Rosoł|Pomidorowa";
    @Pattern(regexp = menu, message = "Invalid dish name. Allowed dishes: Kotlet schabowy, pierogi, Filet z Kurczaka, Frytki, Ziemniaki, Rosół, Pomidorowa")
    private String name;

}
