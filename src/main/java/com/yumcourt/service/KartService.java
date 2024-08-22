package com.yumcourt.service;

import com.yumcourt.model.Kart;
import com.yumcourt.repository.KartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KartService {
    private final KartRepository kartRepository;

    public KartService(KartRepository kartRepository) {
        this.kartRepository = kartRepository;
    }

    public List<Kart> retrieveKarts() {
        return kartRepository.findAll();
    }

    public void createKart(Kart kart) {
        kartRepository.save(kart);
    }

    public void updateKart(Kart kart) {
        kartRepository.save(kart);
    }

    public void deleteKart(long id) {
        kartRepository.deleteById(id);
    }

    public Kart findKartById(long id) {
        return kartRepository.findById(id).orElse(null);
    }
}
