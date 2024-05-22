package com.example.hkt.Salon.domain;

import com.example.hkt.Etiqueta.domain.Etiqueta;
import com.example.hkt.Reserva.domain.Reserva;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Salon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSalon;

    private String nombre;
    private String ubicacion;

    @OneToMany(mappedBy = "salon")
    private List<Reserva> reservas;

    @ManyToMany
    @JoinTable(
            name = "salon_etiqueta",
            joinColumns = @JoinColumn(name = "idSalon"),
            inverseJoinColumns = @JoinColumn(name = "idEtiqueta")
    )
    private List<Etiqueta> etiquetas ;

}
