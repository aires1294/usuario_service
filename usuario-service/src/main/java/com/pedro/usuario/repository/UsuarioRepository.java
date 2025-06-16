package com.pedro.usuario.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pedro.usuario.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
  Optional<Usuario> findByEmail(String email);


  boolean existsByEmail(String mail);
}

