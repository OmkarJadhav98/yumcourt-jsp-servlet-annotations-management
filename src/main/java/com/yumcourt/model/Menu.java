package com.yumcourt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "menu")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    private double price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    private boolean availability;

    public Menu(String name, String description, double price, Restaurant restaurant, boolean availability) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
        this.availability = availability;
    }

    // Additional methods if needed
}
