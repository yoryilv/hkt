package com.example.hkt.Salon.domain;

import com.example.hkt.Salon.domain.Salon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    public List<Salon> findAll() {
        return salonRepository.findAll();
    }

    public Salon findById(int id) {
        return salonRepository.findById(id).orElse(null);
    }

    public Salon save(Salon salon) {
        return salonRepository.save(salon);
    }

    public Salon update(int id, Salon salonDetails) {
        Salon salon = findById(id);
        if (salon != null) {
            salon.setNombre(salonDetails.getNombre());
            salon.setUbicacion(salonDetails.getUbicacion());
            salon.setCapacidad(salonDetails.getCapacidad());
            salon.setDescripcion(salonDetails.getDescripcion());
            return salonRepository.save(salon);
        }
        return null;
    }

    public void delete(int id) {
        salonRepository.deleteById(id);
    }

    public void addEtiqueta(int idSalon, int idEtiqueta) {
        Salon salon = findById(idSalon);
        if (salon != null) {
            Etiqueta etiqueta = etiquetaRepository.findById(idEtiqueta).orElse(null);
            if (etiqueta != null) {
                salon.getEtiquetas().add(etiqueta);
                salonRepository.save(salon);
            }
        }
    }

    public void removeEtiqueta(int idSalon, int idEtiqueta) {
        Salon salon = findById(idSalon);
        if (salon != null) {
            Etiqueta etiqueta = etiquetaRepository.findById(idEtiqueta).orElse(null);
            if (etiqueta != null) {
                salon.getEtiquetas().remove(etiqueta);
                salonRepository.save(salon);
            }
        }
    }
}
