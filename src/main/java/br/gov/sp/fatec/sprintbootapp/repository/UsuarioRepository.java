package br.gov.sp.fatec.sprintbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.gov.sp.fatec.sprintbootapp.entity.Autorizacao;
import br.gov.sp.fatec.sprintbootapp.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /*public List<Usuario> findByNomeContainsIgnoreCase(String nome);

    public Usuario findByNome(String nome);

    @Query("Select u from Usuario u where u.Nome = ?1")
    public Usuario buscaPorNome(String nome);

    public List<Usuario> findByNomeAndSenha(String nome, String Senha);

    @Query("Select u from Usuario u where u.Nome = ?1 and u.Senha = ?2")
    public Usuario buscaPorNomESenha(String nome, String senha);

    public List<Usuario> findByAutorizacoesNome(Autorizacao autorizacao);

    @Query("select u from Usuario u inner join u.autorizacoes a where a.nome = ?1")
    public List<Usuario> buscaPorNomeAutorizacao(Autorizacao autorizacao);*/
    
}