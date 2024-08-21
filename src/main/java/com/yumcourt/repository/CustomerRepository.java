package com.yumcourt.repository;

import com.yumcourt.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // JpaRepository provides methods like save(), findAll(), findById(), deleteById()
}
