package com.example.hkt.Reserva.domain;

import com.example.hkt.Salon.domain.Salon;
import com.example.hkt.Usuario.domain.Usuario;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.*;

@Data
@Entity
public class Reserva {

    @Id
    @GeneratedValue
    private int idReserva;

    private Date fecha;
    private Time horaInicio;
    private Time horaFin;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idSalon")
    private Salon salon;

}
