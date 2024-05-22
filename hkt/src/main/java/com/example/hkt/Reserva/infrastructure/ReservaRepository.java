package com.example.hkt.Reserva.infrastructure;

import com.example.hkt.Reserva.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
