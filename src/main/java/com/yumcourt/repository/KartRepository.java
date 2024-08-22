package com.yumcourt.repository;

import com.yumcourt.model.Kart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KartRepository extends JpaRepository<Kart, Long> {
}
