package br.com.thulestorecolinas.springbootapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.com.thulestorecolinas.springbootapp.entity.Usuario;
import br.com.thulestorecolinas.springbootapp.repository.*;

@SpringBootTest
@Transactional
@Rollback
class SpringBootAppApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void testaInsercao() {
		Usuario usuario = new Usuario();
		usuario.setNome("Usuario");
		usuario.setEmail("email@teste");
		usuario.setSenha("SenhaF0rte");
		usuarioRepo.save(usuario);
		assertNotNull(usuario.getId());
	}
}
