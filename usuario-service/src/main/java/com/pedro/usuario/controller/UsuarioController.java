package com.pedro.usuario.controller;
import com.pedro.usuario.model.Usuario;


import com.pedro.usuario.repository.UsuarioRepository;
import com.pedro.usuario.security.AuthRequest;
import com.pedro.usuario.security.AuthResponse;
import com.pedro.usuario.security.JwtUtil;
import com.pedro.usuario.security.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

  @Autowired
  private UsuarioRepository repo;

  @Autowired
  private UsuarioDetailsServiceImpl usuarioDetailsService;

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @PostMapping
  public Usuario cadastrar(@RequestBody @Valid Usuario usuario) {
    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    return repo.save(usuario);
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AuthRequest request) {
    UserDetails userDetails = usuarioDetailsService.loadUserByUsername(request.getUsername());

    if (passwordEncoder.matches(request.getPassword(), userDetails.getPassword())) {
      String token = jwtUtil.generateToken(userDetails.getUsername());
      return ResponseEntity.ok(new AuthResponse(token));
    }

    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
  }

  @GetMapping
  public List<Usuario> listar() {
    return repo.findAll();
  }
}
