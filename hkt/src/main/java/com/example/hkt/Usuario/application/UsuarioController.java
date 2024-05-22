package com.example.hkt.Usuario.application;

import com.example.hkt.Usuario.domain.Usuario;
import com.example.hkt.Usuario.infrastructure.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/register/{usuario}")
    public ResponseEntity<Void> Registro(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

}
