package com.yumcourt.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_executive_id")
    private DeliveryExecutive deliveryExecutive;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // Constructors
    public Order() {}

    public Order(long id, Customer customer, Menu menu, DeliveryExecutive deliveryExecutive, LocalDateTime timestamp) {
        this.id = id;
        this.customer = customer;
        this.menu = menu;
        this.deliveryExecutive = deliveryExecutive;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public DeliveryExecutive getDeliveryExecutive() {
        return deliveryExecutive;
    }

    public void setDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        this.deliveryExecutive = deliveryExecutive;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
