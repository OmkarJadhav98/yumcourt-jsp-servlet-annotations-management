package com.yumcourt.service;

import com.yumcourt.model.DeliveryExecutive;
import com.yumcourt.repository.DeliveryExecutiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryExecutiveService {

    private final DeliveryExecutiveRepository deliveryExecutiveRepository;

    @Autowired
    public DeliveryExecutiveService(DeliveryExecutiveRepository deliveryExecutiveRepository) {
        this.deliveryExecutiveRepository = deliveryExecutiveRepository;
    }

    public List<DeliveryExecutive> retrieveDeliveryExecutives() {
        return deliveryExecutiveRepository.findAll(); // Use JpaRepository's findAll method
    }

    public void createDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        deliveryExecutiveRepository.save(deliveryExecutive); // Use JpaRepository's save method
    }

    public void updateDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        deliveryExecutiveRepository.save(deliveryExecutive); // Use JpaRepository's save method for both create and update
    }

    public void deleteDeliveryExecutive(long id) {
        deliveryExecutiveRepository.deleteById(id); // Use JpaRepository's deleteById method
    }

    public DeliveryExecutive findDeliveryExecutiveById(long id) {
        return deliveryExecutiveRepository.findById(id).orElse(null); // Handle Optional returned by findById
    }
}
