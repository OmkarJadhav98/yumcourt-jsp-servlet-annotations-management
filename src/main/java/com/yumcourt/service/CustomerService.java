package com.yumcourt.service;

import com.yumcourt.model.Customer;
import com.yumcourt.repository.ContactRepository;
import com.yumcourt.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ContactRepository contactRepository;

    public List<Customer> retrieveCustomers() {
        return customerRepository.findAll();
    }

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }

    public Customer findCustomerById(long id) {
        return customerRepository.findById(id).orElse(null);
    }
}
