package com.yumcourt.controller;

import com.yumcourt.model.DeliveryExecutive;
import com.yumcourt.service.DeliveryExecutiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery-executive")
public class DeliveryExecutiveController {

    @Autowired
    private DeliveryExecutiveService deliveryExecutiveService;

    @GetMapping
    public List<DeliveryExecutive> listDeliveryExecutives() {
        return deliveryExecutiveService.retrieveDeliveryExecutives();
    }

    @GetMapping("/{id}")
    public DeliveryExecutive viewDeliveryExecutive(@PathVariable("id") long id) {
        return deliveryExecutiveService.findDeliveryExecutiveById(id);
    }

    @PostMapping
    public void createDeliveryExecutive(@RequestBody DeliveryExecutive deliveryExecutive) {
        deliveryExecutiveService.createDeliveryExecutive(deliveryExecutive);
    }

    @PutMapping("/{id}")
    public void updateDeliveryExecutive(@PathVariable("id") long id, @RequestBody DeliveryExecutive deliveryExecutive) {
        deliveryExecutive.setId(id);
        deliveryExecutiveService.updateDeliveryExecutive(deliveryExecutive);
    }

    @DeleteMapping("/{id}")
    public void deleteDeliveryExecutive(@PathVariable("id") long id) {
        deliveryExecutiveService.deleteDeliveryExecutive(id);
    }
}
