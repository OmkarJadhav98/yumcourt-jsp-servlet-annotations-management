package com.yumcourt.service;

import com.yumcourt.model.Contact;
import com.yumcourt.model.Address;
import com.yumcourt.model.Menu;
import com.yumcourt.model.Restaurant;
import com.yumcourt.repository.ContactRepository;
import com.yumcourt.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, ContactRepository contactRepository) {
        this.restaurantRepository = restaurantRepository;
        this.contactRepository = contactRepository;
    }

    public List<Restaurant> retrieveRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public void createRestaurant(Restaurant restaurant) {
        contactRepository.save(restaurant.getContact());
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Restaurant restaurant) {
        contactRepository.save(restaurant.getContact());
        restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(long id) {
        restaurantRepository.deleteById(id);
    }
}
