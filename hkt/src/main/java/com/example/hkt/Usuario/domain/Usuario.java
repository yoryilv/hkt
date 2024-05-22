package com.example.hkt.Usuario.domain;


import com.example.hkt.Reserva.domain.Reserva;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue
    private Long IdUsuario;

    private String nombre;
    private String correoElectronico;
    private String contrasena;
    private String telefono;

    @OneToMany
    private List<Reserva> reservas;

    public Long getIdUsuario() {return IdUsuario;}

    public void setIdUsuario(Long idUsuario) {IdUsuario = idUsuario;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getCorreoElectronico() {return correoElectronico;}

    public void setCorreoElectronico(String correoElectronico) {this.correoElectronico = correoElectronico;}

    public String getContrasena() {return contrasena;}

    public void setContrasena(String contrasena) {this.contrasena = contrasena;}

    public String getTelefono() {return telefono;}

    public void setTelefono(String telefono) {this.telefono = telefono;}

    public List<Reserva> getReservas() {return reservas;}

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
