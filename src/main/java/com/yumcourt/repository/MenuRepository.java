package com.yumcourt.repository;

import com.yumcourt.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Optional<Menu> findById(Long id);
}
