package com.example.hkt.Salon.infrastructure;

import com.example.hkt.Salon.domain.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends JpaRepository<Salon,Long> {
}
