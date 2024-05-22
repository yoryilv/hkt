package com.example.hkt.Etiqueta.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hkt.Etiqueta.infrastructure.EtiquetaRepository;

import java.util.List;

@Service
public class EtiquetaService {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    public List<Etiqueta> findAll() {
        return etiquetaRepository.findAll();
    }

    public Etiqueta findById(Long id) {
        return etiquetaRepository.findById(id).orElse(null);
    }

    public Etiqueta save(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    public Etiqueta update(Long id, Etiqueta etiquetaDetails) {
        Etiqueta etiqueta = findById(id);
        if (etiqueta != null) {
            etiqueta.setNombre(etiquetaDetails.getNombre());
            return etiquetaRepository.save(etiqueta);
        }
        return null;
    }

    public void delete(Long id) {
        etiquetaRepository.deleteById(id);
    }
}
