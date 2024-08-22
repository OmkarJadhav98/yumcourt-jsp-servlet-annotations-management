package com.yumcourt.controller;

import com.yumcourt.model.Kart;
import com.yumcourt.service.KartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kart")
public class KartController {

    @Autowired
    private KartService kartService;

    @GetMapping
    public ResponseEntity<List<Kart>> getAllKarts() {
        List<Kart> karts = kartService.retrieveKarts();
        return ResponseEntity.ok(karts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kart> getKartById(@PathVariable long id) {
        Kart kart = kartService.findKartById(id);
        if (kart != null) {
            return ResponseEntity.ok(kart);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<String> createKart(@RequestBody Kart kart) {
        kartService.createKart(kart);
        return ResponseEntity.status(HttpStatus.CREATED).body("Kart created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateKart(@PathVariable long id, @RequestBody Kart kart) {
        if (kartService.findKartById(id) != null) {
            kart.setId(id);
            kartService.updateKart(kart);
            return ResponseEntity.ok("Kart updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Kart ID");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteKart(@PathVariable long id) {
        kartService.deleteKart(id);
        return ResponseEntity.ok("Kart deleted successfully");
    }
}
