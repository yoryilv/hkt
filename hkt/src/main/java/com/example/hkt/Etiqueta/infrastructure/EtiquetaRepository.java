package com.example.hkt.Etiqueta.infrastructure;

import com.example.hkt.Etiqueta.domain.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
