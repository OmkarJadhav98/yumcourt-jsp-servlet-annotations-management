package com.yumcourt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "delivery_executive")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryExecutive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long phoneNo;

    private boolean isAvailable;

    // Optionally, remove or keep this method as per your requirement
    public String getVehicleInfo() {
        return "Vehicle Info Placeholder";
    }
}
