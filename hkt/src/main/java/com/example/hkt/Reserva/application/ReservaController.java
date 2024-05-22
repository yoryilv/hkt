package com.example.hkt.Reserva.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hkt.Reserva.domain.ReservaService;
import com.example.hkt.Reserva.domain.Reserva;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> reservas = reservaService.findAll();
        return ResponseEntity.ok(reservas);
    }

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        Reserva newReserva = reservaService.save(reserva);
        return ResponseEntity.ok(newReserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable int id, @RequestBody Reserva reservaDetails) {
        Reserva updatedReserva = reservaService.update(id, reservaDetails);
        return ResponseEntity.ok(updatedReserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable int id) {
        reservaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
