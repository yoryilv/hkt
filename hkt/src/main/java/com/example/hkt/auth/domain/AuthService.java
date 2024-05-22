package com.example.hkt.auth.domain;

import com.example.hkt.Usuario.domain.Usuario;
import com.example.hkt.Usuario.infrastructure.UsuarioRepository;
import com.example.hkt.auth.dto.JwtAuthResponse;
import com.example.hkt.auth.dto.RegisterReq;
import com.example.hkt.auth.dto.LoginReq;
import com.example.hkt.auth.exceptions.UserAlreadyExistException;
import com.example.hkt.auth.services.UserDetailsImpl;
import com.example.hkt.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public String register(RegisterReq registerReq) {
        if (usuarioRepository.existsByCorreoElectronico(registerReq.getEmail())) {
            throw new UserAlreadyExistException("El correo electrónico ya está en uso!");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(registerReq.getFirstName());
        usuario.setCorreoElectronico(registerReq.getEmail());
        usuario.setContrasena(passwordEncoder.encode(registerReq.getPassword()  ));
        usuario.setTelefono(registerReq.getPhone());

        usuarioRepository.save(usuario);

        return "Usuario registrado exitosamente!";
    }

    public JwtAuthResponse login(LoginReq loginReq) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginReq.getEmail(),
                        loginReq.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateJwtToken((UserDetailsImpl) authentication.getPrincipal());

        return new JwtAuthResponse(jwt);
    }
}
