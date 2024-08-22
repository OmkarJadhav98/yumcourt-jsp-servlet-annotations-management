package com.yumcourt.controller;

import com.yumcourt.model.Restaurant;
import com.yumcourt.model.Contact;
import com.yumcourt.model.Address;
import com.yumcourt.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.retrieveRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable long id) {
        Restaurant restaurant = restaurantService.getRestaurantById(id);
        if (restaurant != null) {
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createRestaurant(@RequestParam long id,
                                                 @RequestParam String name,
                                                 @RequestParam long contactId,
                                                 @RequestParam long phone,
                                                 @RequestParam String addressName,
                                                 @RequestParam long flatNo,
                                                 @RequestParam String buildingName,
                                                 @RequestParam String street,
                                                 @RequestParam String city,
                                                 @RequestParam String state,
                                                 @RequestParam long pinCode) {
        Address address = new Address(0, addressName, flatNo, buildingName, street, city, pinCode, state);
        Contact contact = new Contact(contactId, phone, address);
        Restaurant restaurant = new Restaurant(id, name, contact, List.of()); // Assuming empty menus list for simplicity
        restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRestaurant(@PathVariable long id,
                                                 @RequestParam String name,
                                                 @RequestParam long contactId,
                                                 @RequestParam long phone,
                                                 @RequestParam String addressName,
                                                 @RequestParam long flatNo,
                                                 @RequestParam String buildingName,
                                                 @RequestParam String street,
                                                 @RequestParam String city,
                                                 @RequestParam String state,
                                                 @RequestParam long pinCode) {
        Address address = new Address(0, addressName, flatNo, buildingName, street, city, pinCode, state);
        Contact contact = new Contact(contactId, phone, address);
        Restaurant restaurant = new Restaurant(id, name, contact, List.of()); // Assuming empty menus list for simplicity
        restaurantService.updateRestaurant(restaurant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable long id) {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
