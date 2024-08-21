package com.yumcourt.controller;

import com.yumcourt.model.Customer;
import com.yumcourt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> listCustomers() {
        return customerService.retrieveCustomers();
    }

    @GetMapping("/{id}")
    public Customer viewCustomer(@PathVariable("id") long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public void updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
        customer.setId(id);
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
    }
}
