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
        return deliveryExecutiveRepository.retrieveDeliveryExecutives();
    }

    public void createDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        deliveryExecutiveRepository.createDeliveryExecutive(deliveryExecutive);
    }

    public void updateDeliveryExecutive(DeliveryExecutive deliveryExecutive) {
        deliveryExecutiveRepository.updateDeliveryExecutive(deliveryExecutive);
    }

    public void deleteDeliveryExecutive(long id) {
        deliveryExecutiveRepository.deleteDeliveryExecutive(id);
    }

    public DeliveryExecutive findDeliveryExecutiveById(long id) {
        return deliveryExecutiveRepository.findById(id);
    }
}
