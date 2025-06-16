package com.pedro.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import com.pedro.usuario.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.pedro.usuario.model.Usuario;



@OpenAPIDefinition(
		info = @Info(
				title = "API de Usuários",
				version = "1.0",
				description = "Documentação da API de cadastro e listagem de usuários"
		)
)

@SpringBootApplication
public class UsuarioServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuarioServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UsuarioRepository repository) {
		return args -> {
			if (!repository.existsByEmail("admin@admin.com")) {
				Usuario admin = new Usuario();
				admin.setNome("Admin");
				admin.setEmail("admin@admin.com");
				admin.setSenha("1234"); // lembre de criptografar se necessário
				repository.save(admin);
			}
		};
	}
	}



