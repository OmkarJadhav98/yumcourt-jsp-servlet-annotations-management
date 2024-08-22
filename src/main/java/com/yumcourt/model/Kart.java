package com.yumcourt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "kart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double finalPrice;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Restaurant restaurant;
}
