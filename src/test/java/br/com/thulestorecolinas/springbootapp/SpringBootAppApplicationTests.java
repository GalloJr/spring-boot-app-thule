package br.com.thulestorecolinas.springbootapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import br.com.thulestorecolinas.springbootapp.entity.Autorizacao;
import br.com.thulestorecolinas.springbootapp.entity.Usuario;
import br.com.thulestorecolinas.springbootapp.repository.AutorizacaoRepository;
import br.com.thulestorecolinas.springbootapp.repository.UsuarioRepository;

@SpringBootTest
@Transactional
class SpringBootAppApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepo;

	@Autowired
	private AutorizacaoRepository autRepo;

	@BeforeAll
	static void init(@Autowired JdbcTemplate jdbcTemplate) {
		jdbcTemplate.update(
			"insert into usr_usuario (usr_nome, usr_senha, usr_email) values(?,?,?)",
				"Renato", "admin", "renato@thulestore-colinas.com.br");
		jdbcTemplate.update(
			"insert into aut_autorizacao (aut_nome) values(?)",
				"ROLE_ADMIN");
		jdbcTemplate.update(
			"insert into uau_usuario_autorizacao (usr_id, aut_id) values(?,?)",
				1L, 1L);
	}

	@Test
	void contextLoads() {
	}

	@Test
    void testaInsercao() {
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario");
		usuario.setEmail("email@teste");
		usuario.setSenha("SenhaF0rte");
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        Autorizacao aut = new Autorizacao();
        aut.setNome("ROLE_USUARIO");
        autRepo.save(aut);
        usuario.getAutorizacoes().add(aut);
        usuarioRepo.save(usuario);
        assertNotNull(usuario.getAutorizacoes().iterator().next().getId());
    }

	@Test
    void testaInsercaoAutorizacao() {
        Usuario usuario = new Usuario();
        usuario.setNome("Usuario2");
		usuario.setEmail("email2@teste");
		usuario.setSenha("SenhaF0rte");
        usuarioRepo.save(usuario);
        Autorizacao aut = new Autorizacao();
        aut.setNome("ROLE_USUARIO2");
        aut.setUsuarios(new HashSet<Usuario>());
        aut.getUsuarios().add(usuario);
        autRepo.save(aut);
        assertNotNull(aut.getUsuarios().iterator().next().getId());
    }

	@Test
	void testaAutorizacao() {
		Usuario usuario = usuarioRepo.findById(1L).get();
		assertEquals("ROLE_ADMIN", usuario.getAutorizacoes().iterator().next().getNome());
	}

	 @Test
    void testaUsuario() {
        Autorizacao aut = autRepo.findById(1L).get();
        assertEquals("Renato", aut.getUsuarios().iterator().next().getNome());
    }

	@Test
	void testaBuscaUsuarioNomeContains() {
		List<Usuario> usuarios = usuarioRepo.findByNomeContainsIgnoreCase("A");
		assertFalse(usuarios.isEmpty());
	}

	@Test
	void testaBuscaUsuarioNome() {
		Usuario usuario = usuarioRepo.findByNome("Renato");
		assertNotNull(usuario);
	}

	@Test
	void testaBuscaUsuarioEmail() {
		Usuario usuario = usuarioRepo.findByEmail("renato@thulestore-colinas.com.br");
		assertNotNull(usuario);
	}

	@Test
	void testaBuscaUsuarioNomeSenha() {
		Usuario usuario = usuarioRepo.findByNomeAndSenha("Renato", "admin");
		assertNotNull(usuario);
	}

	@Test
	void testaBuscaUsuarioNomeAutorizacao() {
		List<Usuario> usuarios = usuarioRepo.findByAutorizacoesNome("ROLE_ADMIN");
		assertFalse(usuarios.isEmpty());
	}

	@Test
    void testaBuscaUsuarioNomeQuery() {
        Usuario usuario = usuarioRepo.buscaUsuarioPorNome("Renato");
        assertNotNull(usuario);
    }

	@Test
    void testaBuscaUsuarioNomeSenhaQuery() {
        Usuario usuario = usuarioRepo.buscaUsuarioPorNomeESenha("Renato", "admin");
        assertNotNull(usuario);
    }

	@Test
    void testaBuscaUsuarioNomeAutorizacaoQuery() {
        List<Usuario> usuarios = usuarioRepo.buscaPorNomeAutorizacao("ROLE_ADMIN");
        assertFalse(usuarios.isEmpty());
    }
}
