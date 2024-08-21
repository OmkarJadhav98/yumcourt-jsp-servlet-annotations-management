package com.yumcourt.controller;

import com.yumcourt.model.Address;
import com.yumcourt.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<?> getAllAddresses(@RequestParam(required = false) Long id) {
        if (id != null) {
            Address address = addressService.findAddressById(id);
            if (address != null) {
                return ResponseEntity.ok(address);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("{\"error\": \"Address not found\"}");
            }
        } else {
            List<Address> addresses = addressService.retrieveAddresses();
            return ResponseEntity.ok(addresses);
        }
    }

    @PostMapping
    public ResponseEntity<String> createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("{\"message\": \"Address created successfully\"}");
    }

    @PutMapping
    public ResponseEntity<String> updateAddress(@RequestBody Address address) {
        addressService.updateAddress(address);
        return ResponseEntity.ok("{\"message\": \"Address updated successfully\"}");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAddress(@RequestParam long id) {
        addressService.deleteAddress(id);
        return ResponseEntity.ok("{\"message\": \"Address deleted successfully\"}");
    }
}
