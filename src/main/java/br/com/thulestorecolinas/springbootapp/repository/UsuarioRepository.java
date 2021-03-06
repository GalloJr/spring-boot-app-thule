package br.com.thulestorecolinas.springbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.thulestorecolinas.springbootapp.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

   public List<Usuario> findByNomeContainsIgnoreCase(String nome);

    public Usuario findByNome(String nome);

    @Query("select u from Usuario u where u.nome = ?1")
    public Usuario buscaUsuarioPorNome(String nome);

    public Usuario findByNomeAndSenha(String nome, String senha);

    @Query("select u from Usuario u where u.nome = ?1 and u.senha = ?2")
    public Usuario buscaUsuarioPorNomeESenha(String nome, String senha);

    public Usuario findByEmail(String email);

    public List<Usuario> findByAutorizacoesNome(String autorizacao);

     @Query("select u from Usuario u inner join u.autorizacoes a where a.nome = ?1")
    public List<Usuario> buscaPorNomeAutorizacao(String autorizacao);

    public Usuario findTop1ByNome(String nome);

    public Usuario findTop1ByNomeOrEmail(String username, String username2);
}