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
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long flatNo;
    private String buildingName;
    private String street;
    private String city;
    private long pinCode;
    private String state;

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id", this.id);
        json.put("name", this.name);
        json.put("flatNo", this.flatNo);
        json.put("buildingName", this.buildingName);
        json.put("street", this.street);
        json.put("city", this.city);
        json.put("pinCode", this.pinCode);
        json.put("state", this.state);
        return json;
    }
}
