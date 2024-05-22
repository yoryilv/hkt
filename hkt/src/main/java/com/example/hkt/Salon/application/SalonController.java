package com.example.hkt.Salon.application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hkt.Salon.domain.SalonService;

import java.util.List;

@RestController
@RequestMapping("/salones")
public class SalonController {

    @Autowired
    private SalonService salonService;

    @GetMapping
    public ResponseEntity<List<Salon>> getAllSalons() {
        List<Salon> salones = salonService.findAll();
        return ResponseEntity.ok(salones);
    }

    @PostMapping
    public ResponseEntity<Salon> createSalon(@RequestBody Salon salon) {
        Salon newSalon = salonService.save(salon);
        return ResponseEntity.ok(newSalon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salon> updateSalon(@PathVariable int id, @RequestBody Salon salonDetails) {
        Salon updatedSalon = salonService.update(id, salonDetails);
        return ResponseEntity.ok(updatedSalon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalon(@PathVariable int id) {
        salonService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

