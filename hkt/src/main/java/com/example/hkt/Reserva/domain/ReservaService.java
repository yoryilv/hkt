package com.example.hkt.Reserva.domain;

import com.example.hkt.Reserva.infrastructure.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva findById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public Reserva update(int id, Reserva reservaDetails) {
        Reserva reserva = findById(id);
        if (reserva != null) {
            reserva.setFecha(reservaDetails.getFecha());
            reserva.setHoraInicio(reservaDetails.getHoraInicio());
            reserva.setHoraFin(reservaDetails.getHoraFin());
            return reservaRepository.save(reserva);
        }
        return null;
    }

    public void delete(Long id) {
        reservaRepository.deleteById(id);
    }
}

}
