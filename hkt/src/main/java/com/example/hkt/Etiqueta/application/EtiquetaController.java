package com.example.hkt.Etiqueta.application;

import com.example.hkt.Etiqueta.domain.Etiqueta;
import com.example.hkt.Etiqueta.infrastructure.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/etiquetas")
public class EtiquetaController {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    // GET /etiquetas
    @GetMapping
    public List<Etiqueta> getAllEtiquetas() {
        return etiquetaRepository.findAll();
    }

    // POST /etiquetas
    @PostMapping
    public Etiqueta createEtiqueta(@RequestBody Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    // PUT /etiquetas/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Etiqueta> updateEtiqueta(@PathVariable Long id, @RequestBody Etiqueta etiquetaDetails) {
        Optional<Etiqueta> etiquetaOptional = etiquetaRepository.findById(id);

        if (etiquetaOptional.isPresent()) {
            Etiqueta etiqueta = etiquetaOptional.get();
            etiqueta.setNombre(etiquetaDetails.getNombre());
            // Otros campos a actualizar
            Etiqueta updatedEtiqueta = etiquetaRepository.save(etiqueta);
            return ResponseEntity.ok(updatedEtiqueta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /etiquetas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtiqueta(@PathVariable Long id) {
        if (etiquetaRepository.existsById(id)) {
            etiquetaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


