package com.yumcourt.model;

import lombok.*;
import org.json.JSONObject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long phone;
    private Address address;

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("phone", this.phone);
        json.put("address", new JSONObject(this.address)); // Ensure Address has a proper toString() or implement its toJson() method
        return json;
    }
}