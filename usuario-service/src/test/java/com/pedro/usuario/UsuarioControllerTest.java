package com.pedro.usuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.pedro.usuario.model.Usuario;
import com.pedro.usuario.model.Usuario;



@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Test
  void deveRetornarUsuariosComStatus200() throws Exception {
    mockMvc.perform(get("/usuarios"))
        .andExpect(status().isOk());
  }

  @Test
  void deveCadastrarNovoUsuarioComSucesso() throws Exception {
    Usuario novoUsuario = new Usuario();
    novoUsuario.setNome("Teste");
    novoUsuario.setEmail("teste@exemplo.com");
    novoUsuario.setSenha("123456");

    mockMvc.perform(post("/usuarios")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(novoUsuario)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").exists())
        .andExpect(jsonPath("$.nome").value("Teste"))
        .andExpect(jsonPath("$.email").value("teste@exemplo.com"));
  }
}

