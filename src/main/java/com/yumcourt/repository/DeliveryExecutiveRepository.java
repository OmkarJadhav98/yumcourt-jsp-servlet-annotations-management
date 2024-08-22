package com.yumcourt.repository;

import com.yumcourt.model.DeliveryExecutive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeliveryExecutiveRepository extends JpaRepository<DeliveryExecutive, Long> {
    Optional<DeliveryExecutive> findById(Long id);
}
