package com.pedro.usuario.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String nome;

  @Email
  @NotBlank
  @Column(unique = true)
  private String email;

  @NotBlank
  @JsonIgnore
  private String senha;

  @Schema(hidden = true)

  public String getUsername() {
    return this.email; // ou this.email se for o campo usado como login
  }

  public String getPassword() {
    return this.senha;
  }

  public void setUsername(String username) {
    this.email = username;
  }

  public void setPassword(String password) {
    this.senha = password;
  }

}
